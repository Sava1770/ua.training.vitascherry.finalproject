package ua.training.vitascherry.model.dao.query;

public interface AnswerQuery {

    String CREATE_ANSWER = "INSERT INTO answer (text, is_correct, id_question) VALUES (?, ?, ?)";

    String LAZY_FIND_ALL = "SELECT * FROM answer";
}
