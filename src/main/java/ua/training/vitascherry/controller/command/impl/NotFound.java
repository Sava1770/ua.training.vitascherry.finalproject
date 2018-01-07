package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

public class NotFound implements Command {
    @Override
    public Response execute(HttpServletRequest request) {
        return Response.ERROR_404;
    }
}
