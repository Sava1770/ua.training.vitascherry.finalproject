package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.View.*;

public class StudentProfile implements Command {

    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if(sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() == id) {
            return ADMIN_SIGNED_PAGE;
        }
        if (!sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() != id) {
            return ERROR_403_PAGE;
        }
        User student = userService.getStudentById(id);
        if (student == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("student", student);
        return STUDENT_PAGE;
    }
}
