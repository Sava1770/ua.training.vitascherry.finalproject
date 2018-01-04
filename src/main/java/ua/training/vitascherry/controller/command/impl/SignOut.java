package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ua.training.vitascherry.controller.util.View.SIGN_OUT_PAGE;

public class SignOut implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return SIGN_OUT_PAGE;
    }
}
