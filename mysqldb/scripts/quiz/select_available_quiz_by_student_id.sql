SELECT id_quiz, quiz.name FROM quiz
WHERE id_quiz NOT IN
(SELECT DISTINCT id_quiz FROM question
JOIN answer USING(id_question)
JOIN user_answer USING(id_answer)
WHERE id_user = ?);