package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TopicsListCommand implements Command {

    private final TopicService topicService;

    public TopicsListCommand(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Topic> topics = topicService.getAllTopics();
        request.setAttribute("topics" , topics);
        return "/WEB-INF/view/topic_list.jsp";
    }
}
