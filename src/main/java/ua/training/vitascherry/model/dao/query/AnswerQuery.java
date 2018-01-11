package ua.training.vitascherry.model.dao.query;

public interface AnswerQuery extends Query {

    String CREATE_ANSWER = queries.getString("answer.create");

    String FIND_ALL_ANSWERS = queries.getString("answer.find.all");
}
