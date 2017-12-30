package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizResultDao;
import ua.training.vitascherry.model.entity.QuizResult;

import java.util.List;

public class StudentProgressService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<QuizResult> getAllStudentProgress() {
        try (QuizResultDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findAll();
        }
    }

    public List<QuizResult> getProgressByStudentId(int id) {
        try (QuizResultDao dao = daoFactory.createStudentProgressDao()) {
            return dao.findByStudentId(id);
        }
    }
}
