SELECT * FROM topic
JOIN quiz_topic USING(id_topic)
WHERE id_quiz = ?;