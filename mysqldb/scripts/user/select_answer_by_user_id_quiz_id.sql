SELECT id_quiz, quiz.name, question.text, id_answer, answer.text, answer.is_correct
FROM user_answer
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
WHERE id_user = ? AND id_quiz = ?;