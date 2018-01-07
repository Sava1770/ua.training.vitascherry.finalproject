package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.StudentService;
import ua.training.vitascherry.controller.util.Response;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentList implements Command {

    private StudentService studentService;

    public StudentList(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Response execute(HttpServletRequest req) {
        List<User> students = studentService.getAllStudents();
        if (students == null) {
            return Response.ERROR_404;
        }
        req.setAttribute("students", students);
        return Response.STUDENT_LIST;
    }
}
