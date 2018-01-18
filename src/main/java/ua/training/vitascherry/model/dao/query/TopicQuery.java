package ua.training.vitascherry.model.dao.query;

public interface TopicQuery extends Query {

    String TOPIC_COUNT = queries.getString("topic.count");

    String QUIZ_COUNT_BY_TOPIC = queries.getString("quiz.count.by.topic");

    String CREATE_TOPIC = queries.getString("topic.create");

    String FIND_ALL_TOPICS = queries.getString("topic.find.all");

    String FIND_TOPIC_BY_ID = queries.getString("topic.find.by.id");
}
