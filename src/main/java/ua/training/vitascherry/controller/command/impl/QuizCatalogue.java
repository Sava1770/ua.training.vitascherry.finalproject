package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;

public class QuizCatalogue implements Command {

    private TopicService topicService;

    public QuizCatalogue(TopicService service) {
        this.topicService = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        Topic topic = topicService.getTopicById(id);
        if (topic == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("quizzes", topic.getQuizzes());
        return Response.QUIZ_LIST;
    }
}
