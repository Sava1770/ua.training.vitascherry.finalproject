package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.User;

import java.util.List;

public interface UserService {

    boolean createUser(User user);

    boolean isUniqueEmail(String email);

    User getUserByEmail(String email);

    boolean isValidCredentials(User user, String password);

    List<User> getAllStudents();

    User getStudentById(int id);
}
