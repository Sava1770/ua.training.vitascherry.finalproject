package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import java.util.List;

public class UserService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<User> getAllUsers() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }

    public User getUserById(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }

    public void createUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.create(user);
        }
    }

    public User getUserByEmail(String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findByEmail(email);
        }
    }

    public boolean isUniqueEmail(String email) {
        return getUserByEmail(email) == null;
    }
}
