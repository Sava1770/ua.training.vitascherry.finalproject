package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class QuizListCommand implements Command {

    private final QuizService quizService;

    public QuizListCommand(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        request.setAttribute("quizzes" , quizzes);
        return "/WEB-INF/view/quiz_list.jsp";
    }
}
