package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class QuizList implements Command {

    private QuizService service;

    public QuizList(QuizService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int pageNumber = extractPageNumber(req);
        List<Quiz> quizzes = service.getAllQuizzes(pageNumber * RECORDS_PER_PAGE);
        if (quizzes == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("quizzes", quizzes);
        req.setAttribute("pagesCount", calculatePagesCount(service.getQuizzesCount()));
        return Response.QUIZ_LIST;
    }
}
