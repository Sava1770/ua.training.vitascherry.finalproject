package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

import java.util.List;

public interface QuizDao extends GenericDao<Quiz> {
    int createStudentSolution(User student, Quiz quiz);
    Quiz findByStudentIdQuizId(int studentId, int quizId);
    List<Quiz> findPassedByStudentId(int id);
    List<Quiz> findAvailableByStudentId(int id);
}
