SELECT * FROM quiz
JOIN quiz_topic USING(id_quiz)
WHERE id_topic = ?;