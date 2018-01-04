package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.EntityCreateException;
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
    public int create(Quiz quiz) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_QUIZ)) {
            ps.setString(1, quiz.getName());
            rowsCount = ps.executeUpdate();
            if (rowsCount == 0) {
                throw new EntityCreateException(quiz);
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
        List<Quiz> quizzes = null;
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            quizzes = new ArrayList<>();
            while (rs.next()) {
                quizzes.add(extractQuiz(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }

    @Override
    public int update(Quiz entity) {
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
