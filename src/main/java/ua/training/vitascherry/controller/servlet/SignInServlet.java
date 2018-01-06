package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.SignInService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.INVALID_CREDENTIALS;

public class SignInServlet extends HttpServlet {

    private SignInService signInService;

    @Override
    public void init() throws ServletException {
        signInService = new SignInService(DaoFactory.getInstance());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = signInService.getUserByEmail(req.getParameter("email"));
        if (user != null && signInService.isValidCredentials(user, req.getParameter("password"))) {
            req.getSession().setAttribute("user", user);
        } else {
            req.setAttribute("invalidCredentials", INVALID_CREDENTIALS);
        }
        req.getRequestDispatcher(signInService.getResponse().getPage()).forward(req, resp);
    }
}
