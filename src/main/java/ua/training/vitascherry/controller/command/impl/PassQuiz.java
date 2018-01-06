package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;

public class PassQuiz implements Command {

    private QuizService quizService;

    public PassQuiz(QuizService quizService) {
        this.quizService = quizService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User user = (User) req.getSession().getAttribute("user");
        List<Integer> passedQuizIds = quizService.getAllPassedByStudentId(user.getId()).stream()
                .map(Quiz::getId)
                .collect(Collectors.toList());
        if (passedQuizIds.contains(id)) {
            return Response.ERROR_405;
        }
        Quiz quiz = quizService.getQuizById(id);
        if (quiz == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("quiz", quiz);
        return Response.QUIZ_BODY;
    }
}
