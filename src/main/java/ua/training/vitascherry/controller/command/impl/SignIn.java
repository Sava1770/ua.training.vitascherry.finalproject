package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.RequestParameter;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SignIn implements Command {

    private UserService service;

    public SignIn(UserService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (password == null || RequestParameter.PASSWORD.isInvalid(password) ||
                email == null || RequestParameter.EMAIL.isInvalid(email)) {
            return Response.SIGN_IN;
        }
        User user = service.getUserByEmail(email);
        if (user == null || !service.isValidCredentials(user, password)) {
            req.setAttribute("isInvalidCredentials", true);
            return Response.SIGN_IN;
        }
        req.getSession().setAttribute("user", user);
        return user.getRole().getSignInResponse();
    }
}
