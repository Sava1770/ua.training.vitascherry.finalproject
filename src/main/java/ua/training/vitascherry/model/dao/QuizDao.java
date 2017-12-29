package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public interface QuizDao extends GenericDao<Quiz> {
    List<Quiz> findByTopicId(int id);
}
