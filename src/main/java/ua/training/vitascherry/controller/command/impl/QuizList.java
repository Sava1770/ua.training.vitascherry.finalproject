package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class QuizList implements Command {

    private QuizService quizService;

    public QuizList(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        if (quizzes == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("quizzes", quizzes);
        return Response.QUIZ_LIST;
    }
}
