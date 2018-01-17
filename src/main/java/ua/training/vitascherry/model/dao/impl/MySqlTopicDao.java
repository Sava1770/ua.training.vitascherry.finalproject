package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.dao.query.QueryBuilder;
import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ua.training.vitascherry.model.dao.query.TopicQuery.FIND_TOPIC_BY_ID;
import static ua.training.vitascherry.model.dao.query.TopicQuery.FIND_ALL_TOPICS;
import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.TopicMapper.extractTopic;

public class MySqlTopicDao implements TopicDao {

    private final Connection connection;

    public MySqlTopicDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Topic topic) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Topic findById(int id, Map<QueryOption, String> options) {
        Topic topic = null;
        try (PreparedStatement ps = connection.prepareStatement(options == null ?
                FIND_TOPIC_BY_ID :
                new QueryBuilder(FIND_TOPIC_BY_ID, options).build()
        )) {
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
        return findById(id, null);
    }

    @Override
    public List<Topic> findAll(Map<QueryOption, String> options) {
        List<Topic> topics = null;
        try (PreparedStatement ps = connection.prepareStatement(options == null ?
                FIND_ALL_TOPICS :
                new QueryBuilder(FIND_ALL_TOPICS, options).build()
        )) {
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
        return findAll(null);
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
