SELECT sa.id_student, q.id_quiz, (SELECT COUNT(id_question) question WHERE id_quiz = q.id_quiz) AS questions, SUM(a.is_correct) AS correct
FROM student_answer AS sa
JOIN answer AS a USING(id_answer)
JOIN question AS q USING(id_question)
GROUP BY id_student, id_quiz;
