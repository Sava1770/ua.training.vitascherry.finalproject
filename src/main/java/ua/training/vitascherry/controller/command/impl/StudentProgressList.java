package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.StudentProgressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUD_PRO_LIST_PAGE;

public class StudentProgressList implements Command {

    private final StudentProgressService studentProgressService;

    public StudentProgressList(StudentProgressService service) {
        this.studentProgressService = service;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<StudentProgress> progresses = studentProgressService.getAllProgresses();
        if (progresses == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("progresses", progresses);
        return STUD_PRO_LIST_PAGE;
    }
}
