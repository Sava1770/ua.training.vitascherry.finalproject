package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoUtil {
    public static Student extractFromResultSet(ResultSet rs) throws SQLException {
        return Student.builder()
                .setId(rs.getInt("id_student"))
                .setEmail(rs.getString("email"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .build();
    }
}
