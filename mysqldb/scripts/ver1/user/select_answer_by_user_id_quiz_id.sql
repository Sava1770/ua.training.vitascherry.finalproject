SELECT id_quiz, quiz.name, id_question, question.text, id_answer, answer.text, answer.is_correct
FROM user_answer
JOIN answer USING(id_answer)
JOIN question USING(id_question)
JOIN quiz USING(id_quiz)
WHERE id_user = 2 AND id_quiz = 1;