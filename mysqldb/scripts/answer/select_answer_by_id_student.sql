SELECT * FROM answer
JOIN student_answer USING(id_answer)
JOIN student USING(id_student)
WHERE id_student = 1;