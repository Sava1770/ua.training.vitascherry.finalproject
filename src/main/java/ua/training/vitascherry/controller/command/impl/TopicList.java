package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.TOPIC_LIST;

public class TopicList implements Command {

    private final TopicService topicService = new TopicService();

    @Override
    public String execute(HttpServletRequest request) {
        List<Topic> topics = topicService.getAllTopics();
        request.setAttribute("topics" , topics);
        return TOPIC_LIST;
    }
}
