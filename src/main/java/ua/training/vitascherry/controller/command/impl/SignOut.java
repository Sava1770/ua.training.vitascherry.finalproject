package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOut implements Command {
    @Override
    public Response execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return Response.SIGN_OUT;
    }
}
