package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.RequestParameter;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {

    private UserService userService;

    public Register(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String patronymic = req.getParameter("patronymic");
        if (password == null || !password.equals(confirm) || !RequestParameter.PASSWORD.validate(password) ||
                email == null || !RequestParameter.EMAIL.validate(email) ||
                lastName == null || !RequestParameter.NAME.validate(lastName) ||
                firstName == null || !RequestParameter.NAME.validate(firstName) ||
                patronymic == null || !RequestParameter.NAME.validate(patronymic)) {
            return Response.REGISTER;
        }
        if (!userService.isUniqueEmail(email)) {
            req.setAttribute("email", email);
            req.setAttribute("isNotUniqueEmail", true);
            return Response.REGISTER;
        }
        User user = User.builder()
                .setEmail(email)
                .setRole(User.Role.STUDENT)
                .setPasswordHash(Encryptor.encrypt(password))
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPatronymic(patronymic)
                .build();
        return userService.createUser(user) ? Response.REGISTER_SUCCESS : Response.REGISTER;
    }
}
