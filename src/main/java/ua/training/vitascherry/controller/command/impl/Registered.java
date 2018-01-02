package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class Registered implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/WEB-INF/view/registered.jsp";
    }
}
