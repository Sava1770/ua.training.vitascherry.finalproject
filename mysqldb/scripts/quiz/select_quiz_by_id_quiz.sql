SELECT * FROM quiz
JOIN question USING(id_quiz)
JOIN answer USING(id_question)
WHERE id_quiz = 1;