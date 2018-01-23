package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

/**
 * StudentProgressService.java - an interface of student's progress service.
 * Defines methods for retrieving student's progress data from repository.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     StudentProgress
 */
public interface StudentProgressService {

    /**
     * Returns the number of existing student's progresses.
     *
     * @return a number of student's progresses
     */
    int getProgressesCount();

    /**
     * Returns the number of existing progresses of student of specified id.
     *
     * @param id an id of student
     * @return a number of student's progresses
     */
    int getProgressesCountByStudentId(int id);

    /**
     * Returns a list of existing student's progresses, excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param limit a maximum number of student's progresses to return
     * @param offset a number of previous records of student's progresses to skip
     * @return the List object parameterized by StudentProgress, or null if there was en error reading from repository
     */
    List<StudentProgress> getAllProgresses(int limit, int offset);

    /**
     * Returns a list of existing progresses of student of specified id,
     * excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param id an id of student
     * @param limit a maximum number of student's progresses to return
     * @param offset a number of previous records of student's progresses to skip
     * @return the List object parameterized by StudentProgress, or null if there was en error reading from repository
     */
    List<StudentProgress> getProgressesByStudentId(int id, int limit, int offset);
}
