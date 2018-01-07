package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AvailableQuizzes implements Command {

    private QuizService quizService;

    public AvailableQuizzes(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        List<Quiz> quizzes = quizService.getAllAvailableForStudent(user.getId());
        if (quizzes == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("quizzes", quizzes);
        return Response.QUIZ_LIST;
    }
}
