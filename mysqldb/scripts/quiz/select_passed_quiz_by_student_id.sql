SELECT DISTINCT id_quiz, quiz.name FROM quiz
JOIN question USING(id_quiz)
JOIN answer USING(id_question)
JOIN user_answer USING(id_answer)
WHERE id_user = ?;