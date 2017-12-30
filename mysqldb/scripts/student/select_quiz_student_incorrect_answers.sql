SELECT id_student, student.email, student.first_name, student.last_name, student.patronymic, id_quiz, quiz.name, id_question, question.text, id_answer, answer.text
FROM student
JOIN student_answer USING(id_student)
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
WHERE answer.is_correct = 0;