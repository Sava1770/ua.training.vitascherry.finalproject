package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public interface TopicDao extends GenericDao<Topic> {

    int getTopicsCount();

    int getQuizzesCountByTopic(int id);

    List<Topic> findAll(int offset);

    Topic findById(int id, int offset);
}
