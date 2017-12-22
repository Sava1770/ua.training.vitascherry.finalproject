SELECT * FROM `student`
JOIN `student_answer` USING(`id_student`)
JOIN `answer` USING(`id_answer`)
WHERE `id_answer` = ?;