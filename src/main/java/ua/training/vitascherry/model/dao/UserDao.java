package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.User;

public interface UserDao extends GenericDao<User> {

    int getStudentsCount();

    User findByEmail(String email);
}
