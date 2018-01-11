package ua.training.vitascherry.model.dao.impl;

import ua.training.vitascherry.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPool.getDataSource();

    @Override
    public StudentProgressDao createStudentProgressDao() {
        return new MySqlStudentProgressDao(getConnection());
    }

    @Override
    public UserDao createUserDao() {
        return new MySqlUserDao(getConnection());
    }

    @Override
    public QuizDao createQuizDao() {
        return new MySqlQuizDao(getConnection());
    }

    @Override
    public TopicDao createTopicDao() {
        return new MySqlTopicDao(getConnection());
    }

    @Override
    public QuestionDao createQuestionDao() {
        return new MySqlQuestionDao(getConnection());
    }

    @Override
    public AnswerDao createAnswerDao() {
        return new MySqlAnswerDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
