package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractSolutionQuizId;

public class QuizSolution implements Command {

    private QuizService service;

    public QuizSolution(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int studentId = extractId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != studentId) {
            return Response.FORBIDDEN;
        }
        int quizId = extractSolutionQuizId(req);
        Quiz quiz = service.getQuizById(quizId);
        if (quiz == null) {
            return Response.NOT_FOUND;
        }
        Quiz result = service.getStudentQuizSolution(studentId, quizId);
        if (result == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("quiz", quiz);
        req.setAttribute("result", result);
        return Response.QUIZ_RESULT;
    }
}
