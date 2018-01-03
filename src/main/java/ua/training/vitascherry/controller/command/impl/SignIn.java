package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.View.SIGN_IN_PAGE;

public class SignIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return SIGN_IN_PAGE;
    }
}
