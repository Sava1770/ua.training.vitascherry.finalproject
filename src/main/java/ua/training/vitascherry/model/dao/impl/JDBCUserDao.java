package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.EntityCreateException;
import ua.training.vitascherry.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.UserQuery.*;
import static ua.training.vitascherry.model.dao.util.UserMapper.extractUser;

public class JDBCUserDao implements UserDao {

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(User user) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_STUDENT)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getPatronymic());
            rowsCount = ps.executeUpdate();
            if (rowsCount == 0) {
                throw new EntityCreateException(user);
            }
            connection.commit();
            System.out.println("JDBC Transaction committed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
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
    public User findByEmail(String email) {
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_EMAIL)) {
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
    public List<User> findAll() {
        List<User> students = null;
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_STUDENT)) {
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
            setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setAutoCommit(boolean value) {
        try {
            connection.setAutoCommit(value);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
