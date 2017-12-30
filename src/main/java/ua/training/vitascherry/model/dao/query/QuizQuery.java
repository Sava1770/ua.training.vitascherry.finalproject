package ua.training.vitascherry.model.dao.query;

public interface QuizQuery {
    String LAZY_FIND_ALL = "SELECT * FROM quiz";

    String FIND_BY_ID =
            "SELECT * FROM quiz " +
                    "JOIN question USING(id_quiz) " +
                    "JOIN answer USING(id_question) " +
                    "WHERE id_quiz = ?";

    String FIND_BY_TOPIC_ID =
            "SELECT * FROM quiz " +
            "JOIN quiz_topic USING(id_quiz) " +
            "WHERE id_topic = ?";

    String FIND_BY_STUDENT_ID_QUIZ_ID =
            "SELECT id_quiz, quiz.name, id_question, question.text, id_answer, answer.text, answer.is_correct " +
            "FROM student_answer " +
            "JOIN answer USING(id_answer) " +
            "JOIN question USING(id_question) " +
            "JOIN quiz USING(id_quiz) " +
            "WHERE id_quiz = ? AND id_student = ?";
}
