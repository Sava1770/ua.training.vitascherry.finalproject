package ua.training.vitascherry.model.dao;

import java.util.List;

/**
 * GenericDao.java - an interface of parameterized dao.
 * Defines methods for saving and retrieving data from database.
 *
 * @param <T> a generic object
 * @author  Vitalii Chereshnia
 * @version 1.0
 */
public interface GenericDao<T> extends AutoCloseable {

    /**
     * Creates generic entity.
     * Always returns 0, if entity's data data can not be inserted to the database entirely,
     * so why {@link java.sql.SQLException SQLException} was thrown
     *
     * @param entity a entity object ready to insert
     * @return number of records
     */
    int create (T entity);

    /**
     * Returns the generic entity of specified id.
     *
     * @param id an id of desired entity
     * @return the generic object of the specified id, or null if such does not exist or {@link java.sql.SQLException SQLException} was thrown
     */
    T findById(int id);

    /**
     * Returns a list of existing entities, excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param limit a maximum number of entities to return
     * @param offset a number of previous records of entities to skip
     * @return the List object parameterized by generic entity, or null if {@link java.sql.SQLException SQLException} was thrown
     */
    List<T> findAll(int limit, int offset);

    /**
     * Updates existing generic entity.
     * Always returns 0, if entity's data data can not be updated in the database entirely,
     * so why {@link java.sql.SQLException SQLException} was thrown
     *
     * @param entity an modified existing entity
     * @return number of records that were updated int the database
     */
    int update(T entity);

    /**
     * Deletes existing generic entity of specified id.
     * Always returns 0, if entity's data data can not be deleted from the database entirely,
     * so why {@link java.sql.SQLException SQLException} was thrown
     *
     * @param id an id of desired entity
     * @return number of records that were deleted from the database
     */
    int delete(int id);

    /**
     * Enables or disables autocommit
     *
     * @param enabled a boolean value that represents if autocommit is enabled or not
     */
    void setAutoCommit(boolean enabled);

    /**
     * Closes connection after committing result
     * Method will be called regardless of whether the try statement completes normally or abruptly,
     * if GenericDao object was created in try-with-resource block.
     * Prior to Java SE 7, you can use a finally block to do this manually
     *
     * @see AutoCloseable
     */
    void close();
}
