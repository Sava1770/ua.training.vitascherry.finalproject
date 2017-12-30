package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.util.StudentProgressMapper.extractStudentProgress;
import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.FIND_ALL;

public class JDBCStudentProgressDao implements StudentProgressDao {

    private Connection connection;

    public JDBCStudentProgressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(StudentProgress entity) {

    }

    @Override
    public List<StudentProgress> findAll() {
        List<StudentProgress> progresses = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                progresses.add(extractStudentProgress(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progresses;
    }

    @Override
    public void update(StudentProgress entity) {

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
