package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Topic;

public interface TopicDao extends GenericDao<Topic> {

    int getTopicsCount();
}
