package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.util.Encryptor;
import ua.training.vitascherry.controller.util.Response;

public class SignInService {

    private DaoFactory daoFactory;
    private Response response;

    public SignInService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Response getResponse() {
        return response;
    }

    public User getUserByEmail(String email) {
        response = Response.SIGN_IN;
        try (UserDao dao = daoFactory.createUserDao()) {
            User user = dao.findByEmail(email);
            if (user != null) {
                response = user.getRole().getSignInResponse();
            }
            return user;
        }
    }

    public boolean isValidCredentials(User user, String password) {
        response = Response.SIGN_IN;
        boolean isValid = Encryptor.matches(password, user.getPasswordHash());
        if (isValid) {
            response = user.getRole().getSignInResponse();
        }
        return isValid;
    }
}
