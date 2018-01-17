package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public interface StudentProgressService {

    List<StudentProgress> getAllProgresses();

    List<StudentProgress> getProgressesByStudentId(int id);
}
