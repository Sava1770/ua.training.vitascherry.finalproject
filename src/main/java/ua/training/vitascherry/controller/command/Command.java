package ua.training.vitascherry.controller.command;

import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Response execute(HttpServletRequest request);
}
