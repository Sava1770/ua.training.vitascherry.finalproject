package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.StudentDao;
import ua.training.vitascherry.model.entity.EntityCreateException;
import ua.training.vitascherry.model.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.training.vitascherry.model.dao.query.StudentQuery.CREATE_STUDENT;
import static ua.training.vitascherry.model.dao.query.StudentQuery.FIND_BY_ID_WITH_USER;
import static ua.training.vitascherry.model.dao.query.StudentQuery.LAZY_FIND_ALL_WITH_USER;
import static ua.training.vitascherry.model.dao.util.StudentMapper.extractStudent;
import static ua.training.vitascherry.model.dao.util.UserMapper.extractUser;

public class JDBCStudentDao implements StudentDao {

    private final Connection connection;

    public JDBCStudentDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int create(Student student) {
        int generatedKey = 0;
        try (PreparedStatement ps = connection.prepareStatement(CREATE_STUDENT)) {
            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getPatronymic());
            int rows = ps.executeUpdate();
            if (rows != 0) {
                generatedKey = student.getId();
            } else {
                throw new EntityCreateException(student);
            }
            connection.commit();
            System.out.println("JDBC Transaction committed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
                return 0;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return generatedKey;
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
        List<Student> students = null;
        try (PreparedStatement ps = connection.prepareStatement(LAZY_FIND_ALL_WITH_USER)) {
            ResultSet rs = ps.executeQuery();
            students = new ArrayList<>();
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
