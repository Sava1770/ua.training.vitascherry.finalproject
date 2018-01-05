package ua.training.vitascherry.model.dao.query;

public interface QuizQuery {

    String CREATE_QUIZ = "INSERT INTO quiz (name) VALUES (?)";

    String CREATE_STUDENT_ANSWERS = "INSERT INTO user_answer (id_user, id_answer) VALUES (?, ?)";

    String LAZY_FIND_ALL = "SELECT * FROM quiz";

    String FIND_ALL_PASSED = "SELECT DISTINCT id_quiz, quiz.name FROM quiz " +
                             "JOIN question USING(id_quiz) " +
                             "JOIN answer USING(id_question) " +
                             "JOIN user_answer USING(id_answer) " +
                             "WHERE id_user = ?";

    String FIND_ALL_AVAILABLE = "SELECT id_quiz, quiz.name FROM quiz " +
                                "WHERE id_quiz NOT IN " +
                                "(SELECT DISTINCT id_quiz FROM question " +
                                "JOIN answer USING(id_question) " +
                                "JOIN user_answer USING(id_answer) " +
                                "WHERE id_user = ?)";

    String FIND_BY_ID = "SELECT * FROM quiz " +
                        "JOIN question USING(id_quiz) " +
                        "JOIN answer USING(id_question) " +
                        "WHERE id_quiz = ?";

    String FIND_BY_STUDENT_ID_QUIZ_ID = "SELECT id_quiz, quiz.name, id_question, question.text, id_answer, answer.text, answer.is_correct " +
                                        "FROM user_answer " +
                                        "JOIN answer USING(id_answer) " +
                                        "JOIN question USING(id_question) " +
                                        "JOIN quiz USING(id_quiz) " +
                                        "WHERE id_user = ? AND id_quiz = ?";
}
