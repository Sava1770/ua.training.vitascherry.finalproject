package ua.training.vitascherry.model.dao.query;

public interface QuizQuery {
    String LAZY_FIND_ALL = "SELECT * FROM quiz";
    String FIND_BY_ID = "SELECT * FROM quiz JOIN question USING(id_quiz) JOIN answer USING(id_question) WHERE id_quiz = ?";
    String FIND_BY_TOPIC_ID = "SELECT * FROM quiz JOIN quiz_topic USING(id_quiz) WHERE id_topic = ?";
}
