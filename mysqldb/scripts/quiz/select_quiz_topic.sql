SELECT quiz.name AS quiz, topic.name AS topic
FROM quiz
JOIN quiz_topic USING(id_quiz)
JOIN topic USING(id_topic);