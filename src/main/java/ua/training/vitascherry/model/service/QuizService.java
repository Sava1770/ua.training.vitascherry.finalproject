package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.List;

public class QuizService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static volatile QuizService quizService;

    private QuizService() {}

    public static QuizService getInstance() {
        if( quizService == null ){
            synchronized (QuizService.class){
                if( quizService == null ){
                    quizService = new QuizService();
                }
            }
        }
        return quizService;
    }

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
}
