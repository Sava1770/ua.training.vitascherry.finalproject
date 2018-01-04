package ua.training.vitascherry.model.dao.query;

public interface QuestionQuery {

    String CREATE_QUESTION = "INSERT INTO question (text, id_quiz) VALUES (?, ?)";

    String LAZY_FIND_ALL = "SELECT * FROM question";

    String FIND_ALL = "SELECT * FROM answer " +
                      "JOIN question USING(id_question)";
}
