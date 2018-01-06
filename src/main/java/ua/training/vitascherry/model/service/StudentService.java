package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import java.util.List;

public class StudentService {

    private DaoFactory daoFactory;

    public StudentService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<User> getAllStudents() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }

    public User getStudentById(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }
}
