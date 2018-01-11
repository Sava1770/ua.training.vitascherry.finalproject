package ua.training.vitascherry.model.dao.query;

public interface StudentProgressQuery extends Query {

    String FIND_ALL_PROGRESS = queries.getString("progress.find.all");

    String FIND_PROGRESS_BY_STUDENT = queries.getString("progress.find.by.student");
}
