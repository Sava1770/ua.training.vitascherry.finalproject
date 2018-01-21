package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.User;

import java.util.List;

/**
 * UserService.java - an interface of user service.
 * Defines methods for saving and retrieving user data from repository.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     User
 */
public interface UserService {

    /**
     * Returns the number of existing students.
     *
     * @return a number of users
     */
    int getStudentsCount();

    /**
     * Creates user.
     * Always returns false, if user's data were not inserted to the repository
     *
     * @param user object of type User
     * @return true, if user was created, else - false
     */
    boolean createUser(User user);

    /**
     * Checks if user with specified email already exists in repository
     *
     * @param email email to check
     * @return true, if user with specified email already exists, else - false
     */
    boolean isUniqueEmail(String email);


    /**
     * Returns the User object by it's email.
     *
     * @param email a desired user's email
     * @return the User of the specified email, or null if such does not exist
     */
    User getUserByEmail(String email);


    /**
     * Returns the User object by it's email.
     *
     * @param user an existing User object
     * @param password password to check
     * @return true, if passwords match, else - false
     */
    boolean isValidCredentials(User user, String password);

    /**
     * Returns a list of students,
     * excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param limit a maximum number of users to return
     * @param offset a number of previous records of users to skip
     * @return the List object parameterized by User, or null if there is no quiz
     */
    List<User> getAllStudents(int limit, int offset);

    /**
     * Returns student by it's id.
     *
     * @param id an id of desired User
     * @return the User object of the specified id, or null if such does not exist
     */
    User getStudentById(int id);
}
