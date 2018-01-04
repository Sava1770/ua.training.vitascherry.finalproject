package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;

public interface QuizDao extends GenericDao<Quiz> {
    Quiz findByStudentIdQuizId(int studentId, int quizId);
}
