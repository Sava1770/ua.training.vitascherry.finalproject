package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuestionDao;
import ua.training.vitascherry.model.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.QuestionQuery.CREATE_QUESTION;

public class MySqlQuestionDao implements QuestionDao {

    private final Connection connection;

    public MySqlQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Question question) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_QUESTION)) {
            ps.setString(1, question.getText());
            rowsCount = ps.executeUpdate();
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
