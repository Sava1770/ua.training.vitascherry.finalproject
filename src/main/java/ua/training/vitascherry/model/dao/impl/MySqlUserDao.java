package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.dao.query.Delimiter;
import ua.training.vitascherry.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.UserQuery.*;
import static ua.training.vitascherry.model.dao.util.UserMapper.extractUser;

public class MySqlUserDao implements UserDao {

    private final Connection connection;

    public MySqlUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getStudentsCount() {
        int count = 0;
        try (PreparedStatement ps = connection.prepareStatement(STUDENT_COUNT)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int create(User user) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_USER)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getRole().name());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getPatronymic());
            int insertedRows = ps.executeUpdate();
            connection.commit();
            rowsCount = insertedRows;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return rowsCount;
    }

    @Override
    public User findById(int id) {
        User student = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_STUDENT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<User> findAll(int limit, int offset) {
        List<User> students = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_ALL_STUDENTS)
                .limit(limit)
                .offset(offset)
                .toString())) {
            ResultSet rs = ps.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                students.add(extractUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int update(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setAutoCommit(boolean enabled) {
        try {
            connection.setAutoCommit(enabled);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
