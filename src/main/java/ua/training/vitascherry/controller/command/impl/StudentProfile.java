package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_PAGE;

public class StudentProfile implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID);
        int id = Integer.parseInt(token);
        User student = userService.getStudentById(id);
        if (student == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("student", student);
        return STUDENT_PAGE;
    }
}
