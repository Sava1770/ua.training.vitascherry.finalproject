package ua.training.vitascherry.model.dao.query;

public interface UserQuery {
    String LAZY_FIND_ALL = "SELECT * FROM final_project.user";
    String FIND_BY_ID = "SELECT * FROM final_project.user WHERE id_user = ?";
    String FIND_BY_EMAIL = "SELECT * FROM final_project.user WHERE email = ?";
}
