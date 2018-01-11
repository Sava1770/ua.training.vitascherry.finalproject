package ua.training.vitascherry.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    int create (T entity);
    T findById(int id);
    List<T> findAll();
    int update(T entity);
    int delete(int id);
    void setAutoCommit(boolean enabled);
    void close();
}
