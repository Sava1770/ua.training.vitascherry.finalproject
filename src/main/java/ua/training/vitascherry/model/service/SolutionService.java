package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

/**
 * SolutionService.java - an interface of student's quiz solution service.
 * Defines method for saving student's quiz solution data to repository.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     Quiz
 * @see     User
 */
public interface SolutionService {

    /**
     * Creates student's quiz solution.
     * Always returns false, if student's solution data were not inserted to the repository
     *
     * @param student object of type User with student's id
     * @param quiz object of type Quiz with questions and student's answers
     * @return true, if solution was created, else - false
     */
    boolean createStudentSolution(User student, Quiz quiz);
}
