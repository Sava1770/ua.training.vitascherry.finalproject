package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.AnswerDao;
import ua.training.vitascherry.model.entity.Answer;
import ua.training.vitascherry.model.entity.EntityCreateException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        int generatedKey = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_ANSWER, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, answer.getText());
            ps.setBoolean(2, answer.getIsCorrect());
            ps.setInt(3, answer.getQuestion().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            } else {
                throw new EntityCreateException(answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public Answer findById(int id) {
        // TODO
        return null;
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
    public void update(Answer entity) {
        // TODO
    }

    @Override
    public void delete(int id) {
        // TODO
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
