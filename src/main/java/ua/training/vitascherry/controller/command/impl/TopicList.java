package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class TopicList implements Command {

    private final TopicService service;

    public TopicList(TopicService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int pageNumber = extractPageNumber(req);
        List<Topic> topics = service.getAllTopics(RECORDS_PER_PAGE, pageNumber * RECORDS_PER_PAGE);
        if (topics == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("topics", topics);
        req.setAttribute("pagesCount", calculatePagesCount(service.getTopicsCount()));
        return Response.TOPIC_LIST;
    }
}
