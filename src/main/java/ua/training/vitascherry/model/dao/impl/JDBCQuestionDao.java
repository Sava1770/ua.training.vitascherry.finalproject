package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuestionDao;
import ua.training.vitascherry.model.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.QuestionQuery.FIND_ALL;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestionAnswers;

public class JDBCQuestionDao implements QuestionDao {

    private final Connection connection;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Question entity) {
        // TODO
    }

    @Override
    public Question findById(int id) {
        // TODO
        return null;
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, Question> uniqueQuestions = new HashMap<>();
            while (rs.next()) {
                extractQuestionAnswers(rs, uniqueQuestions);
            }
            questions.addAll(uniqueQuestions.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public void update(Question entity) {
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
