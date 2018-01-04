package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.controller.util.TokenPosition;
import ua.training.vitascherry.model.entity.Student;
import ua.training.vitascherry.model.service.StudentService;

import javax.servlet.http.HttpServletRequest;

import static ua.training.vitascherry.controller.util.Tokenizer.extractToken;
import static ua.training.vitascherry.controller.util.View.ERROR_404_PAGE;
import static ua.training.vitascherry.controller.util.View.STUDENT_PAGE;

public class StudentProfile implements Command {

    private final StudentService studentService = new StudentService();

    @Override
    public String execute(HttpServletRequest req) {
        String token = extractToken(req.getRequestURI(), TokenPosition.PRIMARY_ID);
        int id = Integer.parseInt(token);
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ERROR_404_PAGE;
        }
        req.setAttribute("student", student);
        return STUDENT_PAGE;
    }
}
