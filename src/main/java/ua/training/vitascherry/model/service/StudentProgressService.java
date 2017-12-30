package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.List;

public class StudentProgressService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<StudentProgress> getAllProgress() {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll();
        }
    }
}
