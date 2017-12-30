package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public interface StudentProgressDao extends AutoCloseable {
    void create(StudentProgress entity);
    List<StudentProgress> findAll();
    void update(StudentProgress entity);
    void delete(int id);
    void close();
}