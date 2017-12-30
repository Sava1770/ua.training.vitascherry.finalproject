package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public class QuizService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Quiz> getAllQuizzes() {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAll();
        }
    }

    public Quiz getQuizById(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findById(id);
        }
    }

    public List<Quiz> getQuizzesByTopicId(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findByTopicId(id);
        }
    }

    public Quiz getResultByStudentIdQuizId(int idStudent, int idQuiz) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findByStudentIdQuizId(idStudent, idQuiz);
        }
    }
}
