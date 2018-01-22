package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.dao.query.Delimiter;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentProgressQuery.*;
import static ua.training.vitascherry.model.dao.util.StudentProgressMapper.extractStudentProgress;

public class MySqlStudentProgressDao implements StudentProgressDao {

    private final Connection connection;

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
    public int getProgressesCount() {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_PROGRESS_FOR_COUNT,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rs.last();
                rowsCount = rs.getRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsCount;
    }

    @Override
    public int getProgressesCountByStudent(int id) {
        int rowsCount = 0;
        try (PreparedStatement ps = connection.prepareStatement(PROGRESS_COUNT_BY_STUDENT)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rowsCount = rs.getInt("progress_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsCount;
    }

    @Override
    public List<StudentProgress> findAll(int limit, int offset) {
        List<StudentProgress> progresses = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_ALL_PROGRESS)
                .limit(limit)
                .offset(offset)
                .toString())) {
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
    public List<StudentProgress> findByStudentId(int id, int limit, int offset) {
        List<StudentProgress> studentProgresses = null;
        try (PreparedStatement ps = connection.prepareStatement(new Delimiter(FIND_PROGRESS_BY_STUDENT)
                .limit(limit)
                .offset(offset)
                .toString())) {
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
