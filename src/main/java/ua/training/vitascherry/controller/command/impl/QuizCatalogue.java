package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.service.QuizService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class QuizCatalogue implements Command {

    private QuizService service;

    public QuizCatalogue(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int topicId = extractId(req);
        int pageNumber = extractPageNumber(req);
        List<Quiz> quizzes = service.getAllRelatedToTopic(topicId, RECORDS_PER_PAGE, pageNumber * RECORDS_PER_PAGE);
        if (quizzes == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("isCatalogue", true);
        req.setAttribute("topicId", topicId);
        req.setAttribute("quizzes", quizzes);
        req.setAttribute("pagesCount", calculatePagesCount(service.getRelatedQuizzesCount(topicId)));
        return Response.QUIZ_LIST;
    }
}
