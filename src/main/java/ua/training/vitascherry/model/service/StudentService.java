package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.Student;

import java.util.List;

public class StudentService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Student> getAllStudents(){
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }
}
