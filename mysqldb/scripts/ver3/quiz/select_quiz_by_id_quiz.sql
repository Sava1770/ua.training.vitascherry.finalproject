SELECT id_quiz, quiz.name, id_question, question.text, id_answer, answer.text FROM quiz JOIN problem USING(id_quiz) JOIN question USING(id_question) JOIN question_answer USING(id_question) JOIN answer USING(id_answer) WHERE id_quiz = ?;