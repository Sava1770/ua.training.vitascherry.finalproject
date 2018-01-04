package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_PAGE;

public class PassQuiz implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID);
        int id = Integer.valueOf(token);
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quiz", quiz);
        return QUIZ_PAGE;
    }
}
