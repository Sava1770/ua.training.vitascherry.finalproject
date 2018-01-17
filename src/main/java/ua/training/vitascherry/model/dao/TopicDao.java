package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.Topic;

import java.util.List;
import java.util.Map;

public interface TopicDao extends GenericDao<Topic> {

    List<Topic> findAll(Map<QueryOption, String> options);

    Topic findById(int id, Map<QueryOption, String> options);
}
