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
import java.util.stream.Collectors;

import static ua.training.vitascherry.model.dao.mapper.AnswerMapper.extractAnswer;
import static ua.training.vitascherry.model.dao.mapper.QuestionMapper.extractQuestion;
import static ua.training.vitascherry.model.dao.query.QuestionQuery.FIND_ALL;
import static ua.training.vitascherry.model.utils.EntryFilter.getUniqueValue;

public class JDBCQuestionDao implements QuestionDao {

    private final Connection connection;

    public JDBCQuestionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Question entity) {

    }

    @Override
    public Question findById(int id) {
        return null;
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, Question> uniqueQuestions = new HashMap<>();
            while (rs.next()) {
                Question question = extractQuestion(rs);
                question = getUniqueValue(uniqueQuestions, question.getId(), question);
                question.getAnswers().add(extractAnswer(rs));
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void update(Question entity) {

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
