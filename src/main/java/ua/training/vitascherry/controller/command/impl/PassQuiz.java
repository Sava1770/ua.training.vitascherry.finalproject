package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.ERROR_405_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_PAGE;

public class PassQuiz implements Command {

    private final QuizService quizService = new QuizService();

    @Override
    public String execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User user = (User) req.getSession().getAttribute("user");
        List<Integer> passedQuizIds = quizService.getAllPassedByStudentId(user.getId()).stream()
                .map(Quiz::getId)
                .collect(Collectors.toList());
        if (passedQuizIds.contains(id)) {
            return ERROR_405_PAGE;
        }
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quiz", quiz);
        return QUIZ_PAGE;
    }
}
