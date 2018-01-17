package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.RequestParameter;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class SignIn implements Command {

    private UserService userService;

    public SignIn(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (password == null || !RequestParameter.PASSWORD.validate(password) ||
                email == null || !RequestParameter.EMAIL.validate(email)) {
            return Response.SIGN_IN;
        }
        User user = userService.getUserByEmail(email);
        if (user == null || !userService.isValidCredentials(user, password)) {
            req.setAttribute("isInvalidCredentials", true);
            return Response.SIGN_IN;
        }
        req.getSession().setAttribute("user", user);
        return user.getRole().getSignInResponse();
    }
}
