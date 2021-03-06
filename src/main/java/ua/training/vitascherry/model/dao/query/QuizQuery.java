package ua.training.vitascherry.model.dao.query;

public interface QuizQuery extends Query {

    String QUIZ_COUNT = queries.getString("quiz.count");

    String QUIZ_COUNT_BY_TOPIC = queries.getString("quiz.count.by.topic");

    String CREATE_SOLUTION = queries.getString("solution.create");

    String FIND_BY_TOPIC_ID = queries.getString("quiz.find.by.topic.id");

    String FIND_ALL_QUIZZES = queries.getString("quiz.find.all");

    String FIND_ALL_PASSED = queries.getString("quiz.find.all.passed");

    String FIND_AVAILABLE_QUIZZES = queries.getString("quiz.find.all.available");

    String FIND_QUIZ_BY_ID = queries.getString("quiz.find.by.id");

    String FIND_RESULT_BY_STUDENT_QUIZ = queries.getString("quiz.find.student.solution");
}
