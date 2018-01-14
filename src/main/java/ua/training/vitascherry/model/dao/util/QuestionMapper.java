package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.controller.util.SolutionParameter;
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

    public static Question extractQuestion(String[] solutionParameters) {
        return Question.builder()
                .setId(Integer.parseInt(solutionParameters[SolutionParameter.ID_QUESTION.getIndex()]))
                .build();
    }
}
