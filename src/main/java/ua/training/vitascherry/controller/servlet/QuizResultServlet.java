package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.command.impl.QuizResult;
import ua.training.vitascherry.controller.command.impl.SubmitAnswers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.View.ADMIN_SIGNED_PAGE;
import static ua.training.vitascherry.controller.util.View.ERROR_500_PAGE;

public class QuizResultServlet extends HttpServlet {

    private final Command submitAnswers = new SubmitAnswers();
    private final Command quizResult = new QuizResult();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String responsePage = submitAnswers.execute(req);
        if (!responsePage.equals(ADMIN_SIGNED_PAGE) && !responsePage.equals(ERROR_500_PAGE)) {
            responsePage = quizResult.execute(req);
        }
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
