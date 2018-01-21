package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.User;

/**
 * UserDao.java - an interface of user dao.
 * Defines methods for retrieving user's data from database.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     GenericDao
 * @see     User
 */
public interface UserDao extends GenericDao<User> {

    /**
     * Returns the number of existing records of students.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @return a number of records
     */
    int getStudentsCount();

    /**
     * Returns existing user with specified email
     *
     * @param email a desired user's email
     * @return User object or null if such does not exist or {@link java.sql.SQLException SQLException} was thrown
     */
    User findByEmail(String email);
}
