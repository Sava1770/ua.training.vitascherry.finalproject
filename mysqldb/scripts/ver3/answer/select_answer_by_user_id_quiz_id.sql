SELECT id_quiz, NULL AS `quiz.name`, id_question, NULL AS `question.text`, id_answer, NULL AS `answer.text`, is_correct
FROM solution
JOIN question_answer USING(id_question, id_answer)
WHERE id_user = ? AND id_quiz = ?;