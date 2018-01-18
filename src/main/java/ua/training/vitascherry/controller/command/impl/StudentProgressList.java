package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.StudentProgressService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class StudentProgressList implements Command {

    private StudentProgressService service;

    public StudentProgressList(StudentProgressService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int pageNumber = extractPageNumber(req);
        List<StudentProgress> progresses = service.getAllProgresses(pageNumber * RECORDS_PER_PAGE);
        if (progresses == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("progresses", progresses);
        req.setAttribute("pagesCount", calculatePagesCount(service.getProgressesCount()));
        return Response.STUD_PROS_LIST;
    }
}
