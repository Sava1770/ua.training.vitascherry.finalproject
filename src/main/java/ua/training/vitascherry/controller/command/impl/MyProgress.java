package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;

public class MyProgress implements Command {

    private StudentProgressService progressService;

    public MyProgress(StudentProgressService service) {
        this.progressService = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() == id) {
            return Response.ADMIN_SIGNED_IN;
        }
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != id) {
            return Response.ERROR_403;
        }
        List<StudentProgress> progresses = progressService.getProgressesByStudentId(id);
        if (progresses == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("studentId", id);
        req.setAttribute("progresses", progresses);
        return Response.STUD_PROS;
    }
}
