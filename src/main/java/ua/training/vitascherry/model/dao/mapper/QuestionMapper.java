package ua.training.vitascherry.model.dao.mapper;

import ua.training.vitascherry.model.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper {
    public static Question extractQuestion(ResultSet rs) throws SQLException {
        return Question.builder()
                .setId(rs.getInt("id_question"))
                .setText(rs.getString("question.text"))
                .build();
    }
}
