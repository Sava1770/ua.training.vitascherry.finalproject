package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {
    User findByEmail(String email);
}
