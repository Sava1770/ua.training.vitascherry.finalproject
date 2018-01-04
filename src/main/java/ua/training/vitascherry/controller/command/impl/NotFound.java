package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;

public class NotFound implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return ERROR_404_PAGE;
    }
}
