package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.controller.util.RequestMapper.calculatePagesCount;
import static ua.training.vitascherry.controller.util.RequestMapper.extractPageNumber;

public class StudentList implements Command {

    private UserService service;

    public StudentList(UserService service) {
        this.service = service;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        int pageNumber = extractPageNumber(req);
        List<User> students = service.getAllStudents(pageNumber * RECORDS_PER_PAGE);
        if (students == null) {
            return Response.NOT_FOUND;
        }
        req.setAttribute("students", students);
        req.setAttribute("pagesCount", calculatePagesCount(service.getStudentsCount()));
        return Response.STUDENT_LIST;
    }
}
