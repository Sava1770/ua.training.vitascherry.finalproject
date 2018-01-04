package ua.training.vitascherry.model.dao.query;

public interface TopicQuery {

    String CREATE_TOPIC = "INSERT INTO topic (name) VALUES (?)";

    String LAZY_FIND_ALL = "SELECT * FROM topic";

    String FIND_BY_ID = "SELECT * FROM topic " +
                        "JOIN quiz_topic USING(id_topic) " +
                        "JOIN quiz USING(id_quiz) " +
                        "WHERE id_topic = ?";
}
