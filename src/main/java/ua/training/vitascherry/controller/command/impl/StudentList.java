package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_LIST;

public class StudentList implements Command {

    private final StudentService studentService = new StudentService();

    @Override
    public String execute(HttpServletRequest req) {
        List<Student> students = studentService.getAllStudents();
        if (students == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("students", students);
        return STUDENT_LIST;
    }
}
