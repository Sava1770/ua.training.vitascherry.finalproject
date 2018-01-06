package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.RegisterService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.NOT_UNIQUE_EMAIL;

public class RegisterServlet extends HttpServlet {

    private RegisterService registerService;

    @Override
    public void init() throws ServletException {
        registerService = new RegisterService(DaoFactory.getInstance());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (registerService.isUniqueEmail(req.getParameter("email"))) {
            User user = User.builder()
                    .setEmail(req.getParameter("email"))
                    .setRole(User.Role.STUDENT)
                    .setPasswordHash(Encryptor.encrypt(req.getParameter("password")))
                    .setFirstName(req.getParameter("firstName"))
                    .setLastName(req.getParameter("lastName"))
                    .setPatronymic(req.getParameter("patronymic"))
                    .build();
            registerService.createUser(user);
        } else {
            req.setAttribute("notUniqueEmail", req.getParameter("email") + NOT_UNIQUE_EMAIL);
        }
        req.getRequestDispatcher(registerService.getResponse().getPage()).forward(req, resp);
    }
}
