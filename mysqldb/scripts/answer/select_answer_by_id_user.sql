SELECT * FROM answer
JOIN user_answer USING(id_answer)
JOIN final_project.user USING(id_user)
WHERE id_user = 1;