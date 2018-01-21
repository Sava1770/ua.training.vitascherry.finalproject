package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

import java.util.List;

public interface QuizDao extends GenericDao<Quiz> {

    int getQuizzesCount();

    int getQuizzesCountByTopic(int id);

    int createStudentSolution(User student, Quiz quiz);

    Quiz findByStudentIdQuizId(int studentId, int quizId);

    List<Quiz> findByTopicId(int id, int limit, int offset);

    List<Quiz> findPassedByStudentId(int id);

    List<Quiz> findAvailableByStudentIdTopicId(int studentId, int topicId, int limit, int offset);
}
