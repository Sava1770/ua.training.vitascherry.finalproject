package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private final DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public StudentProgressDao createStudentProgressDao() {
        return new JDBCStudentProgressDao(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public QuizDao createQuizDao() {
        return new JDBCQuizDao(getConnection());
    }

    @Override
    public TopicDao createTopicDao() {
        return new JDBCTopicDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao() {
        return new JDBCQuestionDao(getConnection());
    }

    @Override
    public AnswerDao createAnswerDao() {
        return new JDBCAnswerDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
