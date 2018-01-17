package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao extends GenericDao<User> {

    int getStudentsCount();

    List<User> findAll(Map<QueryOption, String> options);

    User findByEmail(String email);
}
