package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

import static ua.training.vitascherry.controller.util.View.ERROR_500_PAGE;
import static ua.training.vitascherry.controller.util.View.QUIZ_RESULT_PAGE;

public class QuizService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private String quizNextPage = ERROR_500_PAGE;

    public String getQuizNextPage() {
        return quizNextPage;
    }

    public void createStudentAnswers(int studentId, List<Integer> answerIds) {
        quizNextPage = ERROR_500_PAGE;
        try (QuizDao dao = daoFactory.createQuizDao()) {
            dao.setAutoCommit(false);
            if (dao.createStudentAnswers(studentId, answerIds) != 0) {
                quizNextPage = QUIZ_RESULT_PAGE;
            }
        }
    }

    public List<Quiz> getAllQuizzes() {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAll();
        }
    }

    public List<Quiz> getAllPassedByStudentId(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAllPassedByStudent(id);
        }
    }

    public List<Quiz> getAllAvailableForStudent(int id) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            return dao.findAllAvailableForStudent(id);
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
