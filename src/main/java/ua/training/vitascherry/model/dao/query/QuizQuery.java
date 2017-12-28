package ua.training.vitascherry.model.dao.query;

public interface QuizQuery {
    String LAZY_FIND_ALL = "SELECT * FROM quiz";
    String FIND_BY_ID = "JOIN question USING(id_quiz) JOIN answer USING(id_question) WHERE id_quiz = ?";
}
