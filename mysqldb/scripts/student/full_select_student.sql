SELECT * FROM student
JOIN student_answer USING(id_student)
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
JOIN quiz_topic USING(id_quiz)
JOIN topic USING(id_topic);