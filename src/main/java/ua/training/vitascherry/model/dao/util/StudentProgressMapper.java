package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.StudentMapper.extractStudent;

public class StudentProgressMapper {
    public static StudentProgress extractStudentProgress(ResultSet rs) throws SQLException {
        return StudentProgress.builder()
                .setStudent(extractStudent(rs))
                .setQuiz(extractQuiz(rs))
                .setCorrectCount(rs.getInt("correct_count"))
                .setQuestionCount(rs.getInt("question_count"))
                .build();
    }
}
