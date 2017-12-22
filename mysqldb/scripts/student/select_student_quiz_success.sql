SELECT student_answer.id_student, all.id_quiz, all.count AS questions, SUM(is_correct) AS correct
FROM student_answer
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN (SELECT id_quiz, COUNT(id_question) AS count FROM question GROUP BY id_quiz) AS all USING(id_quiz)
GROUP BY id_student, id_quiz, questions;
