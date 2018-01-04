package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.util.Encryptor;

import java.util.List;

import static ua.training.vitascherry.controller.util.View.REGISTER_SUCCESS_PAGE;
import static ua.training.vitascherry.controller.util.View.REGISTER_PAGE;
import static ua.training.vitascherry.controller.util.View.SIGN_IN_PAGE;

public class UserService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private String registerNextPage;
    private String signInNextPage;

    public String getRegisterNextPage() {
        return registerNextPage;
    }


    public String getSignInNextPage() {
        return signInNextPage;
    }

    public void createUser(User user) {
        registerNextPage = REGISTER_PAGE;
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.setAutoCommit(false);
            if (dao.create(user) != 0) {
                registerNextPage = REGISTER_SUCCESS_PAGE;
            }
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
        signInNextPage = SIGN_IN_PAGE;
        boolean isValid = Encryptor.matches(password, user.getPasswordHash());
        System.out.println("Credentials valid: " + isValid);
        if (isValid) {
            signInNextPage = user.getRole().getWelcomePage();
        }
        return isValid;
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
