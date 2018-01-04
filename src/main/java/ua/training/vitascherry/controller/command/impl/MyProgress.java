package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Role;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentProgressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_403_PAGE;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_PROGRESS_PAGE;

public class MyProgress implements Command {

    private final StudentProgressService progressService = new StudentProgressService();

    @Override
    public String execute(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID);
        int id = Integer.parseInt(token);
        User sessionUser = (User)req.getSession().getAttribute("user");
        if (sessionUser.getRole().equals(Role.ADMIN) && sessionUser.getId() == id) {
            return ERROR_404_PAGE;
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
        return STUDENT_PROGRESS_PAGE;
    }
}
