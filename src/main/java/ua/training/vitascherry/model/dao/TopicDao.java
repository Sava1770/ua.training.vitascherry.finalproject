package ua.training.vitascherry.model.dao;

import ua.training.vitascherry.model.entity.Topic;

/**
 * TopicDao.java - an interface of topic dao.
 * Defines methods for retrieving topic's data from database.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     GenericDao
 * @see     Topic
 */
public interface TopicDao extends GenericDao<Topic> {

    /**
     * Returns the number of existing records of topics.
     * Always returns 0 if there is no record or {@link java.sql.SQLException SQLException} was thrown
     *
     * @return a number of records
     */
    int getTopicsCount();
}
