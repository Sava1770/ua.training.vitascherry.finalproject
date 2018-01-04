package ua.training.vitascherry.model.dao.query;

public interface UserQuery {

    String CREATE_STUDENT = "INSERT INTO final_project.user " +
                         "(email, password_hash, first_name, last_name, patronymic) VALUES " +
                         "(?, ?, ?, ?, ?)";

    String FIND_BY_EMAIL = "SELECT * FROM final_project.user WHERE email = ?";

    String LAZY_FIND_STUDENT = "SELECT * FROM final_project.user WHERE role = 'STUDENT'";

    String FIND_STUDENT_BY_ID = "SELECT * FROM final_project.user " +
                                "WHERE id_user = ? AND role = 'STUDENT'";
}
