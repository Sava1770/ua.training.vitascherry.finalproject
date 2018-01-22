package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.MissingTokenException;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractSolutionQuizId;

public class QuizSolution implements Command {

    private final QuizService service;

    public QuizSolution(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int studentId;
        try {
            studentId = extractId(req);
        } catch (MissingTokenException e) {
            return Response.NOT_FOUND;
        }
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != studentId) {
            return Response.FORBIDDEN;
        }
        int quizId;
        try {
            quizId = extractSolutionQuizId(req);
        } catch (MissingTokenException e) {
            return Response.NOT_FOUND;
        }
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
