package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public interface TopicDao extends GenericDao<Topic> {
    List<Topic> findByQuizId(int id);
}
