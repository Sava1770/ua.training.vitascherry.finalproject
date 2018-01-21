package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ua.training.vitascherry.controller.util.RequestMapper.extractId;

public class PassQuiz implements Command {

    private QuizService service;

    public PassQuiz(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int quizId = extractId(req);
        User user = (User) req.getSession().getAttribute("user");
        List<Quiz> passedQuizzes = service.getAllPassedByStudent(user.getId());
        List<Integer> passedQuizIds = passedQuizzes.stream()
            .map(Quiz::getId)
            .collect(Collectors.toList());
        if (passedQuizIds.contains(quizId)) {
            Map<Integer, Topic> quizTopicsMap = passedQuizzes.stream()
                .collect(Collectors.toMap(Quiz::getId, Quiz::getTopic));
            Topic topic = quizTopicsMap.get(quizId);
            req.setAttribute("topicId", topic.getId());
            return Response.WAS_PASSED;
        }
        Quiz quiz = service.getQuizById(quizId);
        if (quiz == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("quiz", quiz);
        return Response.QUIZ_BODY;
    }
}
