package ua.training.vitascherry.model.dao.query;

public interface AnswerQuery extends Query {

    String CREATE_ANSWER = queries.getString("answer.create");

    String CREATE_QUESTION_ANSWER = queries.getString("question.answer.create");

    String FIND_ALL_ANSWERS = queries.getString("answer.find.all");
}
