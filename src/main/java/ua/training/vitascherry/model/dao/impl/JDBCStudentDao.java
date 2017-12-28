package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.mapper.StudentMapper.extractStudent;

public class JDBCStudentDao implements StudentDao {

    private final Connection connection;

    public JDBCStudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Student entity) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        List<Student> subscribers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                subscribers.add(extractStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public void update(Student entity) {

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
