package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuestionDao;
import ua.training.vitascherry.model.entity.EntityCreateException;
import ua.training.vitascherry.model.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.QuestionQuery.CREATE_QUESTION;
import static ua.training.vitascherry.model.dao.query.QuestionQuery.FIND_ALL;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestionAnswers;

public class JDBCQuestionDao implements QuestionDao {

    private final Connection connection;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Question question) {
        int generatedKey = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_QUESTION, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, question.getText());
            ps.setInt(2, question.getQuiz().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            } else {
                throw new EntityCreateException(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public Question findById(int id) {
        // TODO
        return null;
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            questions = new ArrayList<>();
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
