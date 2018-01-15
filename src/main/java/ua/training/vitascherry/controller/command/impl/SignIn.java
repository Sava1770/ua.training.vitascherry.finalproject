package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.SignInService;

import javax.servlet.http.HttpServletRequest;

public class SignIn implements Command {

    private SignInService signInService;

    public SignIn(SignInService signInService) {
        this.signInService = signInService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        User user = signInService.getUserByEmail(req.getParameter("email"));
        if (user != null && signInService.isValidCredentials(user, req.getParameter("password"))) {
            req.getSession().setAttribute("user", user);
        } else {
            req.setAttribute("isInvalidCredentials", true);
        }
       return signInService.getResponse();
    }
}
