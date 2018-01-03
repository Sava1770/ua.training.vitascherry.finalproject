package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.UserQuery.FIND_BY_EMAIL;
import static ua.training.vitascherry.model.dao.util.UserMapper.extractUser;

public class JDBCUserDao implements UserDao {

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        // TODO
    }

    @Override
    public User findById(int id) {
        // TODO
        return null;
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
        // TODO
        return null;
    }

    @Override
    public void update(User entity) {
        // TODO
    }

    @Override
    public void delete(int id) {
        // TODO
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
