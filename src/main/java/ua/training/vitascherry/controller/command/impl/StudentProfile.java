package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentService;
import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;

public class StudentProfile implements Command {

    private StudentService studentService;

    public StudentProfile(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if(sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() == id) {
            return Response.ADMIN_SIGNED_IN;
        }
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != id) {
            return Response.ERROR_403;
        }
        User student = studentService.getStudentById(id);
        if (student == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("student", student);
        return Response.STUDENT_PROFILE;
    }
}
