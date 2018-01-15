package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.RegisterService;
import ua.training.vitascherry.model.util.Encryptor;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {

    private RegisterService registerService;

    public Register(RegisterService registerService) {
        this.registerService = registerService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
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
            req.setAttribute("email", req.getParameter("email"));
            req.setAttribute("isNotUniqueEmail", true);
        }
        return registerService.getResponse();
    }
}
