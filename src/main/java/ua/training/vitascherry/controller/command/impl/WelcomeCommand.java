package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class WelcomeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Welcome user: " + request.getAttribute("user"));
        return "/WEB-INF/view/welcome.jsp";
    }
}
