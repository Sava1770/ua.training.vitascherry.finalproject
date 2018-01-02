package ua.training.vitascherry.model.dao.query;

public interface StudentProgressQuery {
    String FIND_ALL = "SELECT id_student, first_name, last_name, patronymic, id_quiz, quiz.name, " +
            "(SELECT COUNT(id_question) question WHERE id_quiz = que.id_quiz) AS question_count, SUM(ans.is_correct) AS correct_count " +
            "FROM student_answer AS stud_ans " +
            "JOIN answer AS ans USING(id_answer) " +
            "JOIN question AS que USING(id_question) " +
            "JOIN student AS stud USING(id_student) " +
            "JOIN quiz USING(id_quiz) " +
            "GROUP BY id_student, id_quiz";
}
