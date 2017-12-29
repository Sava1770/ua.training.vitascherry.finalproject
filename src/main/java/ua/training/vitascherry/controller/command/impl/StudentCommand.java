package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.model.utils.Tokenizer.extractId;

public class StudentCommand implements Command {

    private final StudentService studentService = new StudentService();

    @Override
    public String execute(HttpServletRequest request) {
        int id = extractId(request.getRequestURI());
        Student student = studentService.getStudentById(id);
        request.setAttribute("student" , student);
        return "/WEB-INF/view/student.jsp";
    }
}
