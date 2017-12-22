SELECT * FROM question
JOIN answer USING(id_question)
WHERE id_answer = ?;