package ua.training.vitascherry.model.dao.query;

public interface UserQuery {

    String CREATE_USER = "INSERT INTO final_project.user " +
                    "(email, password_hash) VALUES " +
                    "(?, ?)";

    String FIND_BY_EMAIL = "SELECT * FROM final_project.user WHERE email = ?";
}
