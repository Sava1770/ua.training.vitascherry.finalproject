package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.Student;

import java.util.List;

public class StudentService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Student> getAllStudents() {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }

    public Student getStudentById(int id) {
        try (StudentDao dao = daoFactory.createStudentDao()) {
            return dao.findById(id);
        }
    }
}
