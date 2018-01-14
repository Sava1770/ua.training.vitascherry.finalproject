package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractSecondaryId;

public class Solution implements Command {

    private QuizService quizService;

    public Solution(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int studentId = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != studentId) {
            return Response.ERROR_403;
        }
        int quizId = extractSecondaryId(req);
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz == null) {
            return Response.ERROR_404;
        }
        Quiz result = quizService.getQuizResult(studentId, quizId);
        if (result == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("quiz", quiz);
        req.setAttribute("result", result);
        return Response.QUIZ_RESULT;
    }
}
