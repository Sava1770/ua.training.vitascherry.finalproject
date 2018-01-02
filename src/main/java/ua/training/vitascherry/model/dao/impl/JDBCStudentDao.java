package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentQuery.FIND_BY_ID_WITH_USER;
import static ua.training.vitascherry.model.dao.query.StudentQuery.LAZY_FIND_ALL;
import static ua.training.vitascherry.model.dao.query.StudentQuery.LAZY_FIND_ALL_WITH_USER;
import static ua.training.vitascherry.model.dao.util.StudentMapper.extractStudent;
import static ua.training.vitascherry.model.dao.util.UserMapper.extractUser;

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
        Student student = null;
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_WITH_USER)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = extractStudent(rs);
                student.setUser(extractUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                students.add(extractStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> findAllWithUser() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL_WITH_USER)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = extractStudent(rs);
                student.setUser(extractUser(rs));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
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
