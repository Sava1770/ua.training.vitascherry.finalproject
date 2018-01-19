package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuestionDao;
import ua.training.vitascherry.model.entity.Question;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MySqlQuestionDao implements QuestionDao {

    private final Connection connection;

    public MySqlQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Question> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int update(Question entity) {
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
