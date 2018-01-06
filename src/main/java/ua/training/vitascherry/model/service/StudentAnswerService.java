package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.util.Response;

import java.util.List;

public class StudentAnswerService {

    private DaoFactory daoFactory;
    private Response response;

    public StudentAnswerService(DaoFactory daoFactory) {
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
}
