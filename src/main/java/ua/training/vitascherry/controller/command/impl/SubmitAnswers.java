package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ADMIN_SIGNED_PAGE;

public class SubmitAnswers implements Command {

    private final QuizService quizService;

    public SubmitAnswers(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equals(Role.ADMIN)) {
            return ADMIN_SIGNED_PAGE;
        }
        List<Integer> answerIds = new ArrayList<>();
        Enumeration<String> en = req.getParameterNames();
        while (en.hasMoreElements()) {
            answerIds.add(Integer.parseInt(en.nextElement()));
        }
        quizService.createStudentAnswers(user.getId(), answerIds);
        return quizService.getQuizNextPage();
    }
}
