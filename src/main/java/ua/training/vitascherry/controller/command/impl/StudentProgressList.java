package ua.training.vitascherry.controller.command.impl;

import ua.training.vitascherry.controller.command.Command;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.StudentProgressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentProgressList implements Command {

    private final StudentProgressService studentProgressService = new StudentProgressService();

    @Override
    public String execute(HttpServletRequest request) {
        List<StudentProgress> progresses = studentProgressService.getAllProgress();
        request.setAttribute("progresses" , progresses);
        return "/WEB-INF/view/student_progress_list.jsp";
    }
}
