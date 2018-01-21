package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.dao.query.Delimiter;
import ua.training.vitascherry.model.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static ua.training.vitascherry.model.dao.query.QuizQuery.*;
import static ua.training.vitascherry.model.dao.util.AnswerMapper.extractAnswer;
import static ua.training.vitascherry.model.dao.util.QuestionMapper.extractQuestion;
import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.TopicMapper.extractTopic;
import static ua.training.vitascherry.model.dao.util.UniqueValueMapper.extractUniqueValue;

public class MySqlQuizDao implements QuizDao {

    private final Connection connection;

    public MySqlQuizDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Quiz quiz) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getQuizzesCount() {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(QUIZ_COUNT)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rowsCount = rs.getInt("quiz_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsCount;
    }

    @Override
    public int getQuizzesCountByTopic(int id) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(QUIZ_COUNT_BY_TOPIC)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rowsCount = rs.getInt("quiz_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsCount;
    }

    @Override
    public int createStudentSolution(User student, Quiz quiz) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_SOLUTION)) {
            for (Question question : quiz.getQuestions()) {
                for (Answer answer : question.getAnswers()) {
                    ps.setInt(1, student.getId());
                    ps.setInt(2, quiz.getId());
                    ps.setInt(3, question.getId());
                    ps.setInt(4, answer.getId());
                    ps.addBatch();
                }
            }
            int batchLength = ps.executeBatch().length;
            connection.commit();
            rowsCount = batchLength;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return rowsCount;
    }

    @Override
    public Quiz findById(int id) {
        Quiz quiz = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_QUIZ_BY_ID)) {
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
        Quiz quiz = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_RESULT_BY_STUDENT_QUIZ)) {
            ps.setInt(1, studentId);
            ps.setInt(2, quizId);
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, Question> uniqueQuestions = new HashMap<>();
            if (rs.next()) {
                quiz = extractQuiz(rs);
                Question question = extractQuestion(rs);
                question = extractUniqueValue(uniqueQuestions, question.getId(), question);
                question.getAnswers().add(extractAnswer(rs));
                while (rs.next()) {
                    question = extractQuestion(rs);
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
    public List<Quiz> findAll(int limit, int offset) {
        List<Quiz> quizzes = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_ALL_QUIZZES)
                .limit(limit)
                .offset(offset)
                .toString())) {
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
    public List<Quiz> findByTopicId(int id, int limit, int offset) {
        List<Quiz> quizzes = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_BY_TOPIC_ID)
                .limit(limit)
                .offset(offset)
                .toString())) {
            ps.setInt(1, id);
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
    public List<Quiz> findPassedByStudentId(int id) {
        List<Quiz> passedQuizzes = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_PASSED)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            passedQuizzes = new ArrayList<>();
            Map<Integer, Topic> uniqueTopics = new HashMap<>();
            while (rs.next()) {
                Topic topic = extractTopic(rs);
                topic = extractUniqueValue(uniqueTopics, topic.getId(), topic);
                Quiz quiz = extractQuiz(rs);
                quiz.setTopic(topic);
                passedQuizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passedQuizzes;
    }

    @Override
    public List<Quiz> findAvailableByStudentIdTopicId(int studentId, int topicId, int limit, int offset) {
        List<Quiz> availableQuizzes = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_AVAILABLE_QUIZZES)
                .limit(limit)
                .offset(offset)
                .toString())) {
            ps.setInt(1, topicId);
            ps.setInt(2, studentId);
            ResultSet rs = ps.executeQuery();
            availableQuizzes = new ArrayList<>();
            while (rs.next()) {
                availableQuizzes.add(extractQuiz(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableQuizzes;
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
