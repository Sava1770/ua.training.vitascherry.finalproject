SELECT * FROM quiz
JOIN question USING(id_quiz)
WHERE id_question = ?;