package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

import java.util.List;


/**
 * QuizDao.java - an interface of quiz dao.
 * Defines methods for retrieving quiz data from database.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     GenericDao
 * @see     Quiz
 */
public interface QuizDao extends GenericDao<Quiz> {

    /**
     * Returns the number of existing records of quizzes.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @return a number of records
     */
    int getQuizzesCount();

    /**
     * Returns the number of existing records of quizzes with specified topic id.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @param id an id of topic
     * @return the number of records
     */
    int getQuizzesCountByTopic(int id);

    /**
     * Creates student's solution records in the database
     * Always returns 0, if data can not be inserted to the database entirely,
     * so why {@link java.sql.SQLException SQLException} was thrown
     *
     * @param student a student object
     * @param quiz a quiz object with student answers
     * @return the number of records
     */
    int createStudentSolution(User student, Quiz quiz);

    /**
     * Returns the Quiz object by it's id with student's answers only.
     *
     * @param studentId an id of student
     * @param quizId an id of desired Quiz
     * @return the Quiz of the specified id, or null if such does not exist or {@link java.sql.SQLException SQLException} was thrown
     */
    Quiz findByStudentIdQuizId(int studentId, int quizId);

    /**
     * Returns the list of existing quizzes with specified topic id.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param id an id of topic
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by Quiz, or null if {@link java.sql.SQLException SQLException} was thrown
     */
    List<Quiz> findByTopicId(int id, int limit, int offset);

    /**
     * Returns a list of existing quizzes that student of specified id have already passed.
     *
     * @param id an id of student
     * @return the List object parameterized by Quiz, or null if {@link java.sql.SQLException SQLException} was thrown
     */
    List<Quiz> findPassedByStudentId(int id);

    /**
     * Returns a list of available quizzes with specified topic id,
     * that student of specified id have not passed yet.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param studentId an id of student
     * @param topicId an id of topic
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by Quiz, or null if {@link java.sql.SQLException SQLException} was thrown
     */
    List<Quiz> findAvailableByStudentIdTopicId(int studentId, int topicId, int limit, int offset);
}
