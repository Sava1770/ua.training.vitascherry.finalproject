package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.MissingTokenException;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractId;

public class StudentProfile implements Command {

    private final UserService service;

    public StudentProfile(UserService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id;
        try {
            id = extractId(req);
        } catch (MissingTokenException e) {
            return Response.NOT_FOUND;
        }
        User user = (User)req.getSession().getAttribute("user");
        if(user.getRole().equals(User.Role.ADMIN) && user.getId() == id) {
            return Response.ADMIN_SIGNED_IN;
        }
        if (!user.getRole().equals(User.Role.ADMIN) && user.getId() != id) {
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
