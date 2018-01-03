package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ua.training.vitascherry.controller.util.View.STUDENT_LIST;

public class StudentList implements Command {

    private final StudentService studentService = new StudentService();

    @Override
    public String execute(HttpServletRequest request) {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students" , students);
        return STUDENT_LIST;
    }
}
