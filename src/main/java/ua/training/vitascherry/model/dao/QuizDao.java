package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

import java.util.List;
import java.util.Map;

public interface QuizDao extends GenericDao<Quiz> {

    int createStudentSolution(User student, Quiz quiz);

    Quiz findByStudentIdQuizId(int studentId, int quizId);

    List<Quiz> findAll(Map<QueryOption, String> options);

    List<Quiz> findPassedByStudentId(int id);

    List<Quiz> findPassedByStudentId(int id, Map<QueryOption, String> options);

    List<Quiz> findAvailableByStudentId(int id);

    List<Quiz> findAvailableByStudentId(int id, Map<QueryOption, String> options);
}
