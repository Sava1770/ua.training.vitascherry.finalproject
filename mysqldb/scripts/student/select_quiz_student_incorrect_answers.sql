SELECT student.email AS student_email, quiz.name AS quiz, question.text AS question, answer.text AS answer
FROM student
JOIN student_answer USING(id_student)
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
WHERE answer.is_correct = 0;