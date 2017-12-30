package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static ua.training.vitascherry.model.dao.util.AnswerMapper.extractAnswer;
import static ua.training.vitascherry.model.dao.util.EntityMapper.extractUniqueValue;

public class QuestionMapper {
    public static Question extractQuestion(ResultSet rs) throws SQLException {
        return Question.builder()
                .setId(rs.getInt("id_question"))
                .setText(rs.getString("question.text"))
                .build();
    }

    public static Question extractQuestionAnswers(ResultSet rs, Map<Integer, Question> uniqueQuestions)
            throws SQLException {
        Question question = extractQuestion(rs);
        question = extractUniqueValue(uniqueQuestions, question.getId(), question);
        question.getAnswers().add(extractAnswer(rs));
        return question;
    }
}
