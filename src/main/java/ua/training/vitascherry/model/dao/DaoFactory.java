package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.impl.MySqlDaoFactory;

public abstract class DaoFactory {

    public abstract QuizDao createQuizDao();

    public abstract TopicDao createTopicDao();

    public abstract StudentProgressDao createStudentProgressDao();

    public abstract UserDao createUserDao();

    private static class DaoFactoryHolder {
        private static final DaoFactory HOLDER_INSTANCE = new MySqlDaoFactory();
    }

    public static DaoFactory getInstance(){
        return DaoFactoryHolder.HOLDER_INSTANCE;
    }
}
