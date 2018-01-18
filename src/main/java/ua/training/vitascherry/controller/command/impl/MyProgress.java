package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractId;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class MyProgress implements Command {

    private StudentProgressService service;

    public MyProgress(StudentProgressService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int id = extractId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() == id) {
            return Response.ADMIN_SIGNED_IN;
        }
        if (!sessionUser.getRole().equals(User.Role.ADMIN) && sessionUser.getId() != id) {
            return Response.FORBIDDEN;
        }
        int pageNumber = extractPageNumber(req);
        List<StudentProgress> progresses = service.getProgressesByStudentId(id, pageNumber * RECORDS_PER_PAGE);
        if (progresses == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("studentId", id);
        req.setAttribute("progresses", progresses);
        req.setAttribute("pagesCount", calculatePagesCount(service.getProgressesCountByStudentId(id)));
        return Response.STUD_PROS;
    }
}
