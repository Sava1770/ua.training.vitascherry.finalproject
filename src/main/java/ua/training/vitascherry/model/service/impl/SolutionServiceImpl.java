package ua.training.vitascherry.model.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.SolutionService;

public class SolutionServiceImpl implements SolutionService {

    private static final Logger logger = LogManager.getLogger(SolutionServiceImpl.class.getName());

    private DaoFactory daoFactory;

    public SolutionServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public boolean createStudentSolution(User student, Quiz quiz) {
        try (QuizDao dao = daoFactory.createQuizDao()) {
            dao.setAutoCommit(false);
            boolean isCreated = (dao.createStudentSolution(student, quiz) != 0);
            if (isCreated) {
                logger.info("User {} passed the quiz id: {}", student.getEmail(), quiz.getId());
            }
            return isCreated;
        }
    }
}
