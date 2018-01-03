package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Question;
import ua.training.vitascherry.model.entity.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.QuizQuery.*;
import static ua.training.vitascherry.model.dao.util.AnswerMapper.extractAnswer;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestion;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestionAnswers;
import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.EntityMapper.extractUniqueValue;

public class JDBCQuizDao implements QuizDao {

    private final Connection connection;

    public JDBCQuizDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Quiz entity) {
        // TODO
    }

    @Override
    public Quiz findById(int id) {
        Quiz quiz = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, Question> uniqueQuestions = new HashMap<>();
            if (rs.next()) {
                quiz = extractQuiz(rs);
                while (rs.next()) {
                    Question question = extractQuestion(rs);
                    question = extractUniqueValue(uniqueQuestions, question.getId(), question);
                    question.getAnswers().add(extractAnswer(rs));
                }
                quiz.getQuestions().addAll(uniqueQuestions.values());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    @Override
    public List<Quiz> findByTopicId(int id) {
        List<Quiz> quizzes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_TOPIC_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quizzes.add(extractQuiz(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public Quiz findByStudentIdQuizId(int studentId, int quizId) {
        Quiz result = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_STUDENT_ID_QUIZ_ID)) {
            ps.setInt(1, studentId);
            ps.setInt(2, quizId);
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, Question> uniqueQuestions = new HashMap<>();
            if (rs.next()) {
                result = extractQuiz(rs);
                extractQuestionAnswers(rs, uniqueQuestions);
                while (rs.next()) {
                    extractQuestionAnswers(rs, uniqueQuestions);
                }
                result.getQuestions().addAll(uniqueQuestions.values());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizzes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quizzes.add(extractQuiz(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public void update(Quiz entity) {
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
