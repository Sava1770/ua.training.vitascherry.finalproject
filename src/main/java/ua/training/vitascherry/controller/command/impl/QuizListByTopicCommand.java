package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Tokenizer.getToken;

public class QuizListByTopicCommand implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest request) {
        String token = getToken(request.getRequestURI(), TokenPosition.ID);
        int id = Integer.parseInt(token);
        List<Quiz> quizzes = quizService.getQuizzesByTopicId(id);
        request.setAttribute("quizzes" , quizzes);
        return "/WEB-INF/view/quiz_list.jsp";
    }
}
