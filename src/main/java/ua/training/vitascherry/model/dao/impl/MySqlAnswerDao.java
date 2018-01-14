package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.AnswerDao;
import ua.training.vitascherry.model.entity.Answer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class MySqlAnswerDao implements AnswerDao {

    private final Connection connection;

    public MySqlAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Answer answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Answer findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Answer> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Answer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        try {
            connection.setAutoCommit(true);
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
