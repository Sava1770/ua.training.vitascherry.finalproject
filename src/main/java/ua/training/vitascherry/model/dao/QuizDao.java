package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

import java.util.List;

public interface QuizDao extends GenericDao<Quiz> {

    int getQuizzesCount();

    int createStudentSolution(User student, Quiz quiz);

    Quiz findByStudentIdQuizId(int studentId, int quizId);

    List<Quiz> findAll(int offset);

    List<Quiz> findPassedByStudentId(int id);

    List<Quiz> findPassedByStudentId(int id, int offset);

    List<Quiz> findAvailableByStudentId(int id);

    List<Quiz> findAvailableByStudentId(int id, int offset);
}
