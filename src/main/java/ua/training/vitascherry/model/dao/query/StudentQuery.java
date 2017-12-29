package ua.training.vitascherry.model.dao.query;

public interface StudentQuery {
    String LAZY_FIND_ALL = "SELECT * FROM student";
    String FIND_BY_ID = "SELECT * FROM student WHERE id_student = ?;";
}
