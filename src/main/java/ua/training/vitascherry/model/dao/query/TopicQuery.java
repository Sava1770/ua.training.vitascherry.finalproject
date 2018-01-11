package ua.training.vitascherry.model.dao.query;

public interface TopicQuery extends Query {

    String CREATE_TOPIC = queries.getString("topic.create");

    String FIND_ALL_TOPICS = queries.getString("topic.find.all");

    String FIND_TOPIC_BY_ID = queries.getString("topic.find.by.id");
}
