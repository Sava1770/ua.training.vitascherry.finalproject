package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.model.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentProgressList implements Command {

    private StudentProgressService studentProgressService;

    public StudentProgressList(StudentProgressService service) {
        this.studentProgressService = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        List<StudentProgress> progresses = studentProgressService.getAllProgresses();
        if (progresses == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("progresses", progresses);
        return Response.STUD_PROS_LIST;
    }
}
