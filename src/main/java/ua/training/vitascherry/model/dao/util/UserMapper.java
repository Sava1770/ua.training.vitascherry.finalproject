package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User extractUser(ResultSet rs) throws SQLException {
        return User.builder()
                .setId(rs.getInt("id_user"))
                .setEmail(rs.getString("email"))
                .setRole(User.Role.valueOf(rs.getString("role")))
                .setPasswordHash(rs.getString("password_hash"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setPatronymic(rs.getString("patronymic"))
                .build();
    }
}
