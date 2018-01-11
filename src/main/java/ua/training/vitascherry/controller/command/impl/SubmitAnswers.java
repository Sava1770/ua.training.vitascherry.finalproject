package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SubmitAnswers implements Command {

    private QuizService quizService;

    public SubmitAnswers(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equals(User.Role.ADMIN)) {
            return Response.ADMIN_SIGNED_IN;
        }
        List<Integer> answerIds = new ArrayList<>();
        Enumeration<String> en = req.getParameterNames();
        while (en.hasMoreElements()) {
            answerIds.add(Integer.parseInt(en.nextElement()));
        }
        quizService.createStudentAnswers(user.getId(), answerIds);
        if (!quizService.getResponse().equals(Response.QUIZ_RESULT)) {
            return Response.ERROR_500;
        }
        return new QuizResult(quizService).execute(req);
    }
}
