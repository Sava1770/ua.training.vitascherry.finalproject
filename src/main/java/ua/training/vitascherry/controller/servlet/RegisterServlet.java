package ua.training.vitascherry.controller.servlet;

import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.vitascherry.controller.util.Message.NOT_UNIQUE_EMAIL;

public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getNamedDispatcher("MainServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (userService.isUniqueEmail(req.getParameter("email"))) {
            User user = User.builder()
                    .setEmail(req.getParameter("email"))
                    .setRole(Role.STUDENT)
                    .setPasswordHash(Encryptor.encrypt(req.getParameter("password")))
                    .setFirstName(req.getParameter("firstName"))
                    .setLastName(req.getParameter("lastName"))
                    .setPatronymic(req.getParameter("patronymic"))
                    .build();
            System.out.println("Student: " + user);
            userService.createUser(user);
        } else {
            req.setAttribute("notUniqueEmail", req.getParameter("email") + NOT_UNIQUE_EMAIL);
        }
        String responsePage = userService.getRegisterNextPage();
        System.out.println("Register response page: " + responsePage);
        req.getRequestDispatcher(responsePage).forward(req, resp);
    }
}
