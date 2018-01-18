package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.GetCommandMap;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.Question;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.service.SolutionService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

import static ua.training.vitascherry.controller.util.RequestMapper.extractSolutionQuizId;

public class SubmitSolution implements Command {

    private SolutionService service;

    public SubmitSolution(SolutionService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getRole().equals(User.Role.ADMIN)) {
            return Response.ADMIN_SIGNED_IN;
        }
        Quiz quiz = Quiz.builder().setId(extractSolutionQuizId(req)).build();
        req.getParameterMap().forEach((questionId, answerIds) ->
                quiz.getQuestions().add(
                        Question.builder()
                                .setId(Integer.parseInt(questionId))
                                .setAnswers(Arrays.stream(answerIds)
                                        .map(answerId -> Answer.builder()
                                                .setId(Integer.parseInt(answerId))
                                                .build())
                                        .collect(Collectors.toList()))
                                .build()));
        if (!service.createStudentSolution(user, quiz)) {
            return Response.SERVER_ERROR;
        }
        return GetCommandMap.getInstance().get("result").execute(req);
    }
}
