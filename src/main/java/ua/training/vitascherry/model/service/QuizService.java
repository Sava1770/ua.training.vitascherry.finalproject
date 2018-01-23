package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

/**
 * QuizService.java - an interface of quiz service.
 * Defines methods for retrieving quiz data from repository.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     Quiz
 */
public interface QuizService {

    /**
     * Returns the number of existing quizzes.
     *
     * @return a number of quizzes
     */
    int getQuizzesCount();

    /**
     * Returns the number of existing quizzes related to topic of specified id.
     *
     * @param id an id of topic
     * @return a number of quizzes
     */
    int getRelatedQuizzesCount(int id);

    /**
     * Returns the Quiz object by it's id.
     *
     * @param id an id of desired Quiz
     * @return the Quiz of the specified id, or null if such does not exist
     */
    Quiz getQuizById(int id);

    /**
     * Returns the Quiz object by it's id with student's answers only.
     *
     * @param studentId an id of student
     * @param quizId an id of desired Quiz
     * @return the Quiz of the specified id, or null if such does not exist
     */
    Quiz getStudentQuizSolution(int studentId, int quizId);

    /**
     * Returns a list of existing quizzes, excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by Quiz, or null if there was en error reading from repository
     */
    List<Quiz> getAllQuizzes(int limit, int offset);

    /**
     * Returns a list of existing Quizzes that student of specified id have already passed.
     *
     * @param id an id of student
     * @return the List object parameterized by Quiz, or null if there was en error reading from repository
     */
    List<Quiz> getAllPassedByStudent(int id);

    /**
     * Returns a list of available quizzes related to desired topic,
     * that student of specified id have not passed yet.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param studentId an id of student
     * @param topicId an id of topic
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by Quiz, or null if there was en error reading from repository
     */
    List<Quiz> getAllAvailableForStudent(int studentId, int topicId, int limit, int offset);

    /**
     * Returns the list of existing quizzes that are related to topic of specified id.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param id an id of topic
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by Quiz, or null if there was en error reading from repository
     */
    List<Quiz> getAllRelatedToTopic(int id, int limit, int offset);
}
