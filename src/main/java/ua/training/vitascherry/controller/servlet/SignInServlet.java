package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.INVALID_CREDENTIALS;

public class SignInServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService(DaoFactory.getInstance());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getUserByEmail(req.getParameter("email"));
        if (user != null && userService.isValidCredentials(user, req.getParameter("password"))) {
            req.getSession().setAttribute("user", user);
        } else {
            req.setAttribute("invalidCredentials", INVALID_CREDENTIALS);
        }
        req.getRequestDispatcher(userService.getSignInNextPage()).forward(req, resp);
    }
}
