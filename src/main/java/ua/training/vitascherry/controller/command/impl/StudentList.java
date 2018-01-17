package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.impl.UserServiceImpl;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentList implements Command {

    private UserServiceImpl userService;

    public StudentList(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        List<User> students = userService.getAllStudents();
        if (students == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("students", students);
        return Response.STUDENT_LIST;
    }
}
