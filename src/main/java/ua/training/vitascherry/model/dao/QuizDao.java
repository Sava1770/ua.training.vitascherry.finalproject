package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public interface QuizDao extends GenericDao<Quiz> {
    int createStudentAnswers(int studentId, List<Integer> answerIds);
    Quiz findByStudentIdQuizId(int studentId, int quizId);
    List<Quiz> findAllPassedByStudent(int id);
    List<Quiz> findAllAvailableForStudent(int id);
}
