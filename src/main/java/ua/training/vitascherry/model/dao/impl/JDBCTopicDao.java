package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.EntityCreateException;
import ua.training.vitascherry.model.entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.TopicQuery.CREATE_TOPIC;
import static ua.training.vitascherry.model.dao.query.TopicQuery.FIND_BY_ID;
import static ua.training.vitascherry.model.dao.query.TopicQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.util.QuizMapper.extractQuiz;
import static ua.training.vitascherry.model.dao.util.TopicMapper.extractTopic;

public class JDBCTopicDao implements TopicDao {

    private final Connection connection;

    public JDBCTopicDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Topic topic) {
        int generatedKey = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_TOPIC, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, topic.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            } else {
                throw new EntityCreateException(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public Topic findById(int id) {
        Topic topic = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
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
    public List<Topic> findAll() {
        List<Topic> topics = null;
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
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
    public void update(Topic entity) {
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
