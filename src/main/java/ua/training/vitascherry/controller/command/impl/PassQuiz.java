package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.TokenPosition;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.View.ERROR_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.QUIZ_PAGE;

public class PassQuiz implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        int id = Integer.parseInt(extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID));
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return ERROR_PAGE;
        }
        req.setAttribute("quiz" , quiz);
        return QUIZ_PAGE;
    }
}
