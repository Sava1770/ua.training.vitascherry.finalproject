package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentListCommand implements Command {

    private final StudentService studentService;

    public StudentListCommand(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students" , students);
        return "/WEB-INF/view/student_list.jsp";
    }
}
