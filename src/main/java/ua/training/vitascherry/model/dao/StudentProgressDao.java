package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public interface StudentProgressDao extends GenericDao<StudentProgress> {

    int getProgressesCount();

    int getProgressesCountByStudent(int id);

    List<StudentProgress> findAll(int offset);

    List<StudentProgress> findByStudentId(int id);

    List<StudentProgress> findByStudentId(int id, int offset);
}