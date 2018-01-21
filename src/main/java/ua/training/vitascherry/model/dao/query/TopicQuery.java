package ua.training.vitascherry.model.dao.query;

public interface TopicQuery extends Query {

    String TOPIC_COUNT = queries.getString("topic.count");

    String FIND_ALL_TOPICS = queries.getString("topic.find.all");
}
