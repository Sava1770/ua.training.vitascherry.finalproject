package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public class QuizService {

    private DaoFactory daoFactory;

    public QuizService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Quiz> getAllQuizzes() {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAll();
        }
    }

    public List<Quiz> getAllPassedByStudentId(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findPassedByStudentId(id);
        }
    }

    public List<Quiz> getAllAvailableForStudent(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAvailableForStudentId(id);
        }
    }

    public Quiz getQuizById(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findById(id);
        }
    }

    public Quiz getQuizResult(int studentId, int quizId) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findByStudentIdQuizId(studentId, quizId);
        }
    }
}
