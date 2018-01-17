package ua.training.vitascherry.model.service.impl;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.StudentProgressService;

import java.util.List;

public class StudentProgressServiceImpl implements StudentProgressService {

    private DaoFactory daoFactory;

    public StudentProgressServiceImpl(DaoFactory factory) {
        this.daoFactory = factory;
    }

    @Override
    public List<StudentProgress> getAllProgresses() {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll();
        }
    }

    @Override
    public List<StudentProgress> getProgressesByStudentId(int id) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findByStudentId(id);
        }
    }
}
