package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.FIND_PROGRESS_BY_STUDENT;
import static ua.training.vitascherry.model.dao.util.StudentProgressMapper.extractStudentProgress;
import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.FIND_ALL_PROGRESS;

public class MySqlStudentProgressDao implements StudentProgressDao {

    private Connection connection;

    public MySqlStudentProgressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(StudentProgress entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StudentProgress findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<StudentProgress> findByStudentId(int id) {
        List<StudentProgress> studentProgresses = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_PROGRESS_BY_STUDENT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            studentProgresses = new ArrayList<>();
            while (rs.next()) {
                studentProgresses.add(extractStudentProgress(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentProgresses;
    }

    @Override
    public List<StudentProgress> findAll() {
        List<StudentProgress> progresses = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_PROGRESS)) {
            ResultSet rs = ps.executeQuery();
            progresses = new ArrayList<>();
            while (rs.next()) {
                progresses.add(extractStudentProgress(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progresses;
    }

    @Override
    public int update(StudentProgress entity) {
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
