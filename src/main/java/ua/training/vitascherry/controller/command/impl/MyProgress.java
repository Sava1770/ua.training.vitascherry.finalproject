package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentProgressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.RequestMapper.extractPrimaryId;
import static ua.training.vitascherry.controller.util.View.*;

public class MyProgress implements Command {

    private final StudentProgressService progressService;

    public MyProgress(StudentProgressService service) {
        this.progressService = service;
    }

    @Override
    public String execute(HttpServletRequest req) {
        int id = extractPrimaryId(req);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() == id) {
            return ADMIN_SIGNED_PAGE;
        }
        if (!sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() != id) {
            return ERROR_403_PAGE;
        }
        List<StudentProgress> progresses = progressService.getProgressesByStudentId(id);
        if (progresses == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("studentId", id);
        req.setAttribute("progresses", progresses);
        return STUD_PRO_PAGE;
    }
}
