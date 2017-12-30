package ua.training.vitascherry.model.dao.query;

public interface QuestionQuery {
    String LAZY_FIND_ALL = "SELECT * FROM question";

    String FIND_ALL =
            "SELECT * FROM answer " +
            "JOIN question USING(id_question)";
}
