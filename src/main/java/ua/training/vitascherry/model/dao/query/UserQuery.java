package ua.training.vitascherry.model.dao.query;

public interface UserQuery extends Query {

    String CREATE_STUDENT = queries.getString("user.create");

    String FIND_USER_BY_EMAIL = queries.getString("user.find.by.email");

    String FIND_ALL_STUDENTS = queries.getString("user.find.students");

    String FIND_STUDENT_BY_ID = queries.getString("user.find.student.by.id");
}
