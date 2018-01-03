package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public interface StudentProgressDao extends GenericDao<StudentProgress> {
    List<StudentProgress> findByStudentId(int id);
}