package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.dao.query.Delimiter;
import ua.training.vitascherry.model.entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;
import static ua.training.vitascherry.model.dao.query.TopicQuery.*;
import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.TopicMapper.extractTopic;

public class MySqlTopicDao implements TopicDao {

    private final Connection connection;

    public MySqlTopicDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int getTopicsCount() {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(TOPIC_COUNT)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rowsCount = rs.getInt("topic_count");
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
    public int create(Topic topic) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Topic findById(int id, int offset) {
        Topic topic = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_TOPIC_BY_ID)
                .limit(RECORDS_PER_PAGE)
                .offset(offset)
                .toString())) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                topic = extractTopic(rs);
                topic.getQuizzes().add(extractQuiz(rs));
                while (rs.next()) {
                    topic.getQuizzes().add(extractQuiz(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topic;
    }

    @Override
    public Topic findById(int id) {
        return findById(id, DEFAULT_OFFSET);
    }

    @Override
    public List<Topic> findAll(int offset) {
        List<Topic> topics = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_ALL_TOPICS)
                .limit(RECORDS_PER_PAGE)
                .offset(offset)
                .toString())) {
            ResultSet rs = ps.executeQuery();
            topics = new ArrayList<>();
            while (rs.next()) {
                topics.add(extractTopic(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }

    @Override
    public List<Topic> findAll() {
        return findAll(DEFAULT_OFFSET);
    }

    @Override
    public int update(Topic entity) {
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
