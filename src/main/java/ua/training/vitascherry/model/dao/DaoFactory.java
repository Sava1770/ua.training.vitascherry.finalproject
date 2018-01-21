package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.impl.MySqlDaoFactory;

public abstract class DaoFactory {

    private static volatile DaoFactory daoFactory;

    public abstract QuizDao createQuizDao();

    public abstract TopicDao createTopicDao();

    public abstract StudentProgressDao createStudentProgressDao();

    public abstract UserDao createUserDao();

    public static DaoFactory getInstance(){
        if (daoFactory == null) {
            synchronized (DaoFactory.class){
                if (daoFactory == null){
                    daoFactory = new MySqlDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
