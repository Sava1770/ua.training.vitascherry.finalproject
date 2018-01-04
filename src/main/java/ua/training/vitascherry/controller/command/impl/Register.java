package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.View.REGISTER_PAGE;

public class Register implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        return REGISTER_PAGE;
    }
}
