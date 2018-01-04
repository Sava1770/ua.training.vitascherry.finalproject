package ua.training.vitascherry.model.dao.query;

public interface StudentQuery {

    String CREATE_STUDENT = "INSERT INTO final_project.student VALUES (?, ?, ?, ?)";

    String LAZY_FIND_ALL = "SELECT * FROM student";

    String LAZY_FIND_ALL_WITH_USER = "SELECT * FROM student " +
                                     "JOIN final_project.user ON id_student = id_user";

    String FIND_BY_ID = "SELECT * FROM student WHERE id_student = ?";

    String FIND_BY_ID_WITH_USER = "SELECT * FROM student " +
                                  "JOIN final_project.user ON id_student = id_user " +
                                  "WHERE id_student = ?";
}
