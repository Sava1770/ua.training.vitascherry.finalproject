package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocale implements Command {
    @Override
    public Response execute(HttpServletRequest req) {
        String locale = req.getParameter("locale");
        req.getSession().setAttribute("locale", locale);
        return Response.HOME;
    }
}
