package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_LIST_PAGE;

public class QuizCatalogue implements Command {

    private final TopicService topicService;

    public QuizCatalogue(TopicService service) {
        this.topicService = service;
    }

    @Override
    public String execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        Topic topic = topicService.getTopicById(id);
        if (topic == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("quizzes", topic.getQuizzes());
        return QUIZ_LIST_PAGE;
    }
}
