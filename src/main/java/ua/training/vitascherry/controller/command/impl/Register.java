package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.RequestParameter;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {

    private UserService service;

    public Register(UserService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String patronymic = req.getParameter("patronymic");
        if (password == null || !password.equals(confirm) ||
                RequestParameter.PASSWORD.isInvalid(password) ||
                email == null || RequestParameter.EMAIL.isInvalid(email) ||
                lastName == null || RequestParameter.NAME.isInvalid(lastName) ||
                firstName == null || RequestParameter.NAME.isInvalid(firstName) ||
                patronymic == null || RequestParameter.NAME.isInvalid(patronymic)) {
            return Response.REGISTER;
        }
        if (!service.isUniqueEmail(email)) {
            req.setAttribute("email", email);
            req.setAttribute("isNotUniqueEmail", true);
            return Response.REGISTER;
        }
        User user = User.builder()
            .setEmail(email)
            .setPasswordHash(Encryptor.encrypt(password))
            .setRole(User.Role.STUDENT)
            .setFirstName(firstName)
            .setLastName(lastName)
            .setPatronymic(patronymic)
            .build();
        return service.createUser(user) ? Response.REGISTER_SUCCESS : Response.REGISTER;
    }
}
