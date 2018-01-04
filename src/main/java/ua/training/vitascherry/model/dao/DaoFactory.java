package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {

    private static volatile DaoFactory daoFactory;

    public abstract QuizDao createQuizDao();
    public abstract TopicDao createTopicDao();
    public abstract QuestionDao createQuestionDao();
    public abstract AnswerDao createAnswerDao();
    public abstract StudentProgressDao createStudentProgressDao();
    public abstract UserDao createUserDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
