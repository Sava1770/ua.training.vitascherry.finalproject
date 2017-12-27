package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract StudentDao createStudentDao();

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
