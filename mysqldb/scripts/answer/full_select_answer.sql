SELECT * FROM answer
JOIN student_answer USING(id_answer)
JOIN student USING(id_student)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
JOIN quiz_topic USING(id_quiz)
JOIN topic USING(id_topic);