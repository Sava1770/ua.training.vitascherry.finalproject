package ua.training.vitascherry.model.dao.util;

import ua.training.vitascherry.model.entity.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicMapper {
    public static Topic extractTopic(ResultSet rs) throws SQLException {
        return Topic.builder()
                .setId(rs.getInt("id_topic"))
                .setName(rs.getString("topic.name"))
                .build();
    }
}
