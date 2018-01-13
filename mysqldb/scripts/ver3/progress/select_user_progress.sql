SELECT id_user, email, role, password_hash, first_name, last_name, patronymic, id_quiz, quiz.name, COUNT(DISTINCT id_question) AS question_count, SUM(is_correct) AS correct_count
FROM final_project.user
JOIN solution USING(id_user)
JOIN question_answer USING(id_question, id_answer)
JOIN quiz USING(id_quiz)
GROUP BY id_user, id_quiz;
