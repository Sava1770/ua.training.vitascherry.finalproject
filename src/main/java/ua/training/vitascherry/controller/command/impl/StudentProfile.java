package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractId;

public class StudentProfile implements Command {

    private UserService service;

    public StudentProfile(UserService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if(sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() == id) {
            return Response.ADMIN_SIGNED_IN;
        }
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != id) {
            return Response.FORBIDDEN;
        }
        User student = service.getStudentById(id);
        if (student == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("student", student);
        return Response.STUDENT_PROFILE;
    }
}
