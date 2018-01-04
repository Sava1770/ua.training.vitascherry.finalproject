package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_LIST;

public class StudentList implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest req) {
        List<User> students = userService.getAllStudents();
        if (students == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("students", students);
        return STUDENT_LIST;
    }
}
