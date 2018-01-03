package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.View.INDEX_PAGE;

public class Home implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return INDEX_PAGE;
    }
}
