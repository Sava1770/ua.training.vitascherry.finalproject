package ua.training.vitascherry.model.dao.mapper;

import ua.training.vitascherry.model.entity.Quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizMapper {
    public static Quiz extractQuiz(ResultSet rs) throws SQLException {
        return Quiz.builder()
                .setId(rs.getInt("id_quiz"))
                .setName(rs.getString("name"))
                .build();
    }
}
