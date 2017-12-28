package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.AnswerDao;
import ua.training.vitascherry.model.entity.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.AnswerQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.mapper.AnswerMapper.extractAnswer;

public class JDBCAnswerDao implements AnswerDao {

    private final Connection connection;

    public JDBCAnswerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Answer entity) {

    }

    @Override
    public Answer findById(int id) {
        return null;
    }

    @Override
    public List<Answer> findAll() {
        List<Answer> answers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
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

    }

    @Override
    public void delete(int id) {

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
