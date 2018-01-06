package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.util.Response;

public class RegisterService {

    private DaoFactory daoFactory;
    private Response response;

    public RegisterService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Response getResponse() {
        return response;
    }

    public void createUser(User user) {
        response = Response.REGISTER;
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.setAutoCommit(false);
            if (dao.create(user) != 0) {
                response = Response.REGISTER_SUCCESS;
            }
        }
    }

    public boolean isUniqueEmail(String email) {
        response = Response.REGISTER;
        try (UserDao dao = daoFactory.createUserDao()) {
            boolean isUnique = (dao.findByEmail(email) == null);
            if (isUnique) {
                response = Response.REGISTER_SUCCESS;
            }
            return isUnique;
        }
    }
}
