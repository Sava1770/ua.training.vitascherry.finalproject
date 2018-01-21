package ua.training.vitascherry.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

class DataSourceHolder {

    private static volatile DataSource dataSource;

    private DataSourceHolder() {}

    static DataSource getDataSource() {
        if (dataSource == null){
            synchronized (DataSourceHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:mysql://localhost:3306/student_inspector");
                    ds.setDriverClassName("com.mysql.jdbc.Driver");
                    ds.setUsername("root");
                    ds.setPassword("root");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}