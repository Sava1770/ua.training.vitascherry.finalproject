package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.QuizResult;
import ua.training.vitascherry.controller.command.impl.SubmitAnswers;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.service.QuizService;
import ua.training.vitascherry.model.service.StudentAnswerService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizResultServlet extends HttpServlet {

    private Command submitAnswers;
    private Command quizResult;

    @Override
    public void init() throws ServletException {
        submitAnswers = new SubmitAnswers(new StudentAnswerService(DaoFactory.getInstance()));
        quizResult = new QuizResult(new QuizService(DaoFactory.getInstance()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Response response = submitAnswers.execute(req);
        if (!response.equals(Response.ADMIN_SIGNED_IN) && !response.equals(Response.ERROR_500)) {
            response = quizResult.execute(req);
        }
        req.getRequestDispatcher(response.getPage()).forward(req, resp);
    }
}
