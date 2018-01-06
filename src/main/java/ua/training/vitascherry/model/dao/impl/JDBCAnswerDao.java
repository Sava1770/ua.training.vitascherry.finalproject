package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.AnswerDao;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.util.EntityCreateException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static ua.training.vitascherry.model.dao.query.AnswerQuery.CREATE_ANSWER;
import static ua.training.vitascherry.model.dao.query.AnswerQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.util.AnswerMapper.extractAnswer;

public class JDBCAnswerDao implements AnswerDao {

    private final Connection connection;

    public JDBCAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Answer answer) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_ANSWER)) {
            ps.setString(1, answer.getText());
            ps.setBoolean(2, answer.getIsCorrect());
            ps.setInt(3, answer.getQuestion().getId());
            rowsCount = ps.executeUpdate();
            if (rowsCount == 0) {
                throw new EntityCreateException(answer);
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
    public Answer findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Answer> findAll() {
        List<Answer> answers = null;
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            answers = new ArrayList<>();
            while (rs.next()) {
                answers.add(extractAnswer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
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
