package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.controller.util.QuizParameterPosition;
import ua.training.vitascherry.model.entity.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper {

    public static Answer extractAnswer(ResultSet rs) throws SQLException {
        return Answer.builder()
                .setId(rs.getInt("id_answer"))
                .setText(rs.getString("answer.text"))
                .setIsCorrect(rs.getBoolean("is_correct"))
                .build();
    }

    public static Answer extractAnswer(String[] solutionParameters) {
        return Answer.builder()
                .setId(Integer.parseInt(solutionParameters[QuizParameterPosition.ID_ANSWER.getIndex()]))
                .build();
    }
}
