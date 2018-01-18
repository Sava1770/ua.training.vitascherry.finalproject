package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AvailableQuizzes implements Command {

    private QuizService service;

    public AvailableQuizzes(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        List<Quiz> quizzes = service.getAllAvailableForStudent(user.getId());
        if (quizzes == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("quizzes", quizzes);
        return Response.QUIZ_LIST;
    }
}
