package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.FIND_BY_STUDENT_ID;
import static ua.training.vitascherry.model.dao.util.StudentProgressMapper.extractStudentProgress;
import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.FIND_ALL;

public class JDBCStudentProgressDao implements StudentProgressDao {

    private Connection connection;

    public JDBCStudentProgressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(StudentProgress entity) {
        // TODO
    }

    @Override
    public StudentProgress findById(int id) {
        // TODO
        return null;
    }

    @Override
    public List<StudentProgress> findByStudentId(int id) {
        List<StudentProgress> progresses = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_STUDENT_ID)) {
            ps.setInt(1, id);
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
