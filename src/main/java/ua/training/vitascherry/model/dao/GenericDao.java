package ua.training.vitascherry.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    int create (T entity);
    T findById(int id);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
    void close();
    void setAutoCommit(boolean value);
}
