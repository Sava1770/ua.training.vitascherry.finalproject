package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TopicList implements Command {

    private TopicService topicService;

    public TopicList(TopicService service) {
        this.topicService = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        List<Topic> topics = topicService.getAllTopics();
        if (topics == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("topics", topics);
        return Response.TOPIC_LIST;
    }
}
