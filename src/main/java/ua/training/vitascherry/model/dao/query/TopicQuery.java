package ua.training.vitascherry.model.dao.query;

public interface TopicQuery {
    String LAZY_FIND_ALL = "SELECT * FROM topic";
    String FIND_BY_QUIZ_ID = "SELECT * FROM topic JOIN quiz_topic USING(id_topic) WHERE id_quiz = ?";
}
