package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.util.Encryptor;

public class UserService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public int createUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.setAutoCommit(false);
            return dao.create(user);
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

    public boolean isValidCredentials(User user, String password) {
        return Encryptor.matches(password, user.getPasswordHash());
    }
}
