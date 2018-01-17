package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public interface StudentProgressService {

    List<StudentProgress> getAllProgresses();

    List<StudentProgress> getAllProgresses(int offset);

    List<StudentProgress> getProgressesByStudentId(int id);

    List<StudentProgress> getProgressesByStudentId(int id, int offset);
}
