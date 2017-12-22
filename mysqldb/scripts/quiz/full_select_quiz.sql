SELECT * FROM quiz
JOIN quiz_topic USING(id_quiz)
JOIN topic USING(id_topic)
JOIN question USING(id_quiz)
JOIN answer USING(id_question)
JOIN student_answer USING(id_answer)
JOIN student USING(id_student);