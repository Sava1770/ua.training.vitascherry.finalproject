package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

/**
 * StudentProgressDao.java - an interface of student's progress dao.
 * Defines methods for retrieving student's progress data from database.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     GenericDao
 * @see     StudentProgress
 */
public interface StudentProgressDao extends GenericDao<StudentProgress> {

    /**
     * Returns the number of existing records of progresses.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @return a number of records
     */
    int getProgressesCount();

    /**
     * Returns the number of existing records of progresses of specified student.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @param id an id of student
     * @return the number of records
     */
    int getProgressesCountByStudent(int id);

    /**
     * Returns the list of existing progresses of specified student.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param id an id of student
     * @param limit a maximum number of quizzes to return
     * @param offset a number of previous records of quizzes to skip
     * @return the List object parameterized by StudentProgress, or null if {@link java.sql.SQLException SQLException} was thrown
     */
    List<StudentProgress> findByStudentId(int id, int limit, int offset);
}