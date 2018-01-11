package ua.training.vitascherry.model.service;

import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public class QuizService {

    private DaoFactory daoFactory;
    private Response response;

    public QuizService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Response getResponse() {
        return response;
    }

    public void createStudentAnswers(int studentId, List<Integer> answerIds) {
        response = Response.ERROR_500;
        try (QuizDao dao = daoFactory.createQuizDao()) {
            dao.setAutoCommit(false);
            if (dao.createStudentAnswers(studentId, answerIds) != 0) {
                response = Response.QUIZ_RESULT;
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
