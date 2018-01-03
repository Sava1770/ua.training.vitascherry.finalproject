package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_PAGE;
import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.QUIZ_LIST_PAGE;

public class QuizCatalogue implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest request) {
        String token = extractToken(request.getRequestURI(), TokenPosition.PRIMARY_ID);
        int id = Integer.parseInt(token);
        List<Quiz> quizzes = quizService.getQuizzesByTopicId(id);
        if (quizzes.isEmpty()) {
            return ERROR_PAGE;
        }
        request.setAttribute("quizzes" , quizzes);
        return QUIZ_LIST_PAGE;
    }
}
