package ua.training.vitascherry.controller.command;

import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Response execute(HttpServletRequest request);
}
