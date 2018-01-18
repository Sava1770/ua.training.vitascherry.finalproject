package ua.training.vitascherry.model.dao.query;

public interface StudentProgressQuery extends Query {

    String FIND_ALL_PROGRESS_FOR_COUNT = queries.getString("progress.find.all.for.count");

    String PROGRESS_COUNT_BY_STUDENT = queries.getString("progress.by.student.count");

    String FIND_ALL_PROGRESS = queries.getString("progress.find.all");

    String FIND_PROGRESS_BY_STUDENT = queries.getString("progress.find.by.student");
}
