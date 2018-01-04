package ua.training.vitascherry.model.dao.query;

public interface StudentProgressQuery {

    String FIND_ALL = "SELECT id_user, email, role, password_hash, first_name, last_name, patronymic, id_quiz, quiz.name, (SELECT COUNT(id_question) question WHERE id_quiz = que.id_quiz) AS question_count, SUM(ans.is_correct) AS correct_count " +
                      "FROM final_project.user AS usr " +
                      "JOIN user_answer AS usr_ans USING(id_user) " +
                      "JOIN answer AS ans USING(id_answer) " +
                      "JOIN question AS que USING(id_question) " +
                      "JOIN quiz USING(id_quiz) " +
                      "GROUP BY id_user, id_quiz";

    String FIND_BY_STUDENT_ID = "SELECT id_user, email, role, password_hash, first_name, last_name, patronymic, id_quiz, quiz.name, (SELECT COUNT(id_question) question WHERE id_quiz = que.id_quiz) AS question_count, SUM(ans.is_correct) AS correct_count " +
                                "FROM final_project.user AS usr " +
                                "JOIN user_answer AS usr_ans USING(id_user) " +
                                "JOIN answer AS ans USING(id_answer) " +
                                "JOIN question AS que USING(id_question) " +
                                "JOIN quiz USING(id_quiz) " +
                                "WHERE id_user = ? " +
                                "GROUP BY id_user, id_quiz";
}
