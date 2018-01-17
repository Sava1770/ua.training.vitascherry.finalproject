package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;
import java.util.Map;

public interface StudentProgressDao extends GenericDao<StudentProgress> {

    List<StudentProgress> findAll(Map<QueryOption, String> options);

    List<StudentProgress> findByStudentId(int id);

    List<StudentProgress> findByStudentId(int id, Map<QueryOption, String> options);
}