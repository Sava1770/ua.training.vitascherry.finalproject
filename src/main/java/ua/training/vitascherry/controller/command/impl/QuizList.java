package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_LIST_PAGE;

public class QuizList implements Command {

    private final QuizService quizService;

    public QuizList(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        if (quizzes == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quizzes", quizzes);
        return QUIZ_LIST_PAGE;
    }
}
