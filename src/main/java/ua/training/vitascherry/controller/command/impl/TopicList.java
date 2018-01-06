package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.TOPIC_LIST;

public class TopicList implements Command {

    private final TopicService topicService;

    public TopicList(TopicService service) {
        this.topicService = service;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Topic> topics = topicService.getAllTopics();
        if (topics == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("topics", topics);
        return TOPIC_LIST;
    }
}
