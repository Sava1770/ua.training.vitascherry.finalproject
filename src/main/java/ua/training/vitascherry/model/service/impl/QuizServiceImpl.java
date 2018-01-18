package ua.training.vitascherry.model.service.impl;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.QuizService;

import java.util.List;

public class QuizServiceImpl implements QuizService {

    private DaoFactory daoFactory;

    public QuizServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public int getQuizzesCount() {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.getQuizzesCount();
        }
    }

    @Override
    public List<Quiz> getAllQuizzes(int offset) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAll(offset);
        }
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAll();
        }
    }

    @Override
    public List<Quiz> getAllPassedByStudent(int id, int offset) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findPassedByStudentId(id, offset);
        }
    }

    @Override
    public List<Quiz> getAllPassedByStudent(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findPassedByStudentId(id);
        }
    }

    @Override
    public List<Quiz> getAllAvailableForStudent(int id, int offset) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAvailableByStudentId(id, offset);
        }
    }

    @Override
    public List<Quiz> getAllAvailableForStudent(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAvailableByStudentId(id);
        }
    }

    @Override
    public Quiz getQuizById(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findById(id);
        }
    }

    @Override
    public Quiz getStudentQuizSolution(int studentId, int quizId) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findByStudentIdQuizId(studentId, quizId);
        }
    }
}
