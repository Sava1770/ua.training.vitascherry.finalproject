package ua.training.vitascherry.model.dao.query;

public interface QuestionQuery extends Query {

    String CREATE_QUESTION = queries.getString("question.create");

    String FIND_ALL_QUESTIONS = queries.getString("question.find.all");
}
