package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.model.utils.Tokenizer.extractId;

public class QuizCommand implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest request) {
        int id = extractId(request.getRequestURI());
        Quiz quiz = quizService.getQuizById(id);
        request.setAttribute("quiz" , quiz);
        return "/WEB-INF/view/quiz.jsp";
    }
}
