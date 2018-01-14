package ua.training.vitascherry.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;

public class SolutionService {

    private static final Logger logger = LogManager.getLogger(SolutionService.class.getName());

    private DaoFactory daoFactory;
    private Response response;

    public SolutionService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public Response getResponse() {
        return response;
    }

    public void createStudentSolution(User student, Quiz quiz) {
        response = Response.ERROR_500;
        try (QuizDao dao = daoFactory.createQuizDao()) {
            dao.setAutoCommit(false);
            if (dao.createStudentSolution(student, quiz) != 0) {
                response = Response.QUIZ_RESULT;
                logger.info("User {} successfully passed the quiz id: {}", student.getEmail(), quiz.getId());
            }
        }
    }
}
