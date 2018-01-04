package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_RESULT_PAGE;

public class QuizResult implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        int studentId = Integer.parseInt(extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID));
        int quizId = Integer.parseInt(extractToken(req.getRequestURI(), TokenPosition.SECONDARY_ID));
        Quiz quiz = quizService.getQuizById(quizId);
        Quiz result = quizService.getQuizResult(studentId, quizId);
        if (quiz == null || result == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quiz", quiz);
        req.setAttribute("result", result);
        return QUIZ_RESULT_PAGE;
    }
}
