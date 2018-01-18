package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class QuizCatalogue implements Command {

    private TopicService service;

    public QuizCatalogue(TopicService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractId(req);
        int pageNumber = extractPageNumber(req);
        Topic topic = service.getTopicById(id, pageNumber * RECORDS_PER_PAGE);
        if (topic == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("topicId", id);
        req.setAttribute("quizzes", topic.getQuizzes());
        req.setAttribute("pagesCount", calculatePagesCount(service.getQuizzesCountByTopicId(id)));
        return Response.QUIZ_LIST;
    }
}
