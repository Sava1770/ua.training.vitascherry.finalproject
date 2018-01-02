package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Student;

import java.util.List;

public interface StudentDao extends GenericDao<Student> {
    List<Student> findAllWithUser();
}
