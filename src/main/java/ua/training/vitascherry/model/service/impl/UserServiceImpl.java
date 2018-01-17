package ua.training.vitascherry.model.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.UserService;
import ua.training.vitascherry.model.util.Encryptor;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

    private DaoFactory daoFactory;

    public UserServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean createUser(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.setAutoCommit(false);
            boolean isCreated = (dao.create(user) != 0);
            if (isCreated) {
                logger.info("Registered STUDENT {}", user.getEmail());
            }
            return isCreated;
        }
    }

    @Override
    public boolean isUniqueEmail(String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            boolean isUnique = (dao.findByEmail(email) == null);
            if (!isUnique) {
                logger.warn("User with email {} already exists", email);
            }
            return isUnique;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try (UserDao dao = daoFactory.createUserDao()) {
            User user = dao.findByEmail(email);
            if (user == null) {
                logger.warn("User with email {} was not found!", email);
            }
            return user;
        }
    }

    @Override
    public boolean isValidCredentials(User user, String password) {
        boolean isValid = Encryptor.matches(password, user.getPasswordHash());
        if (isValid) {
            logger.info("{} {} logged in", user.getRole(), user.getEmail());
        } else {
            logger.warn("Invalid credentials email: {}, password: {}", user.getEmail(), password);
        }
        return isValid;
    }

    @Override
    public List<User> getAllStudents() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        }
    }

    @Override
    public User getStudentById(int id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        }
    }
}
