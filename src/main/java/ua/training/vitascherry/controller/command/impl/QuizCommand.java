package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.TokenPosition;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Tokenizer.getToken;

public class QuizCommand implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        String token = getToken(req.getRequestURI(), TokenPosition.ID);
        int id = Integer.parseInt(token);
        Quiz quiz = quizService.getQuizById(id);
        req.setAttribute("quiz" , quiz);
        return "/WEB-INF/view/quiz.jsp";
    }
}
