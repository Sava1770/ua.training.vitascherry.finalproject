package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public StudentDao createStudentDao() {
        return new JDBCStudentDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
