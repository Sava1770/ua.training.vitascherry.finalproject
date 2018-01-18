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
    public int getProgressesCount() {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.getProgressesCount();
        }
    }

    @Override
    public int getProgressesCountByStudentId(int id) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.getProgressesCountByStudent(id);
        }
    }

    @Override
    public List<StudentProgress> getAllProgresses(int offset) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll(offset);
        }
    }

    @Override
    public List<StudentProgress> getAllProgresses() {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll();
        }
    }

    @Override
    public List<StudentProgress> getProgressesByStudentId(int id, int offset) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findByStudentId(id, offset);
        }
    }

    @Override
    public List<StudentProgress> getProgressesByStudentId(int id) {
        try (StudentProgressDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findByStudentId(id);
        }
    }
}
