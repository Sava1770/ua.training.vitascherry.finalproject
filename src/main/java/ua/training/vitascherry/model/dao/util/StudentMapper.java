package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper {
    public static Student extractStudent(ResultSet rs) throws SQLException {
        return Student.builder()
                .setId(rs.getInt("id_student"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setPatronymic(rs.getString("patronymic"))
                .build();
    }
}
