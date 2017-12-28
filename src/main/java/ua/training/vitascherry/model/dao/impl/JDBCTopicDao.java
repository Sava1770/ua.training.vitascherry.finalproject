package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.TopicQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.mapper.TopicMapper.extractTopic;

public class JDBCTopicDao implements TopicDao {

    private final Connection connection;

    public JDBCTopicDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Topic entity) {

    }

    @Override
    public Topic findById(int id) {
        return null;
    }

    @Override
    public List<Topic> findAll() {
        List<Topic> topics = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
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
