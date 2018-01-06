package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractSecondaryId;
import static ua.training.vitascherry.controller.util.View.ERROR_403_PAGE;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_RESULT_PAGE;

public class QuizResult implements Command {

    private final QuizService quizService;

    public QuizResult(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        int studentId = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (!sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() != studentId) {
            return ERROR_403_PAGE;
        }
        int quizId = extractSecondaryId(req);
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz == null) {
            return ERROR_404_PAGE;
        }
        Quiz result = quizService.getQuizResult(studentId, quizId);
        if (result == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quiz", quiz);
        req.setAttribute("result", result);
        return QUIZ_RESULT_PAGE;
    }
}
