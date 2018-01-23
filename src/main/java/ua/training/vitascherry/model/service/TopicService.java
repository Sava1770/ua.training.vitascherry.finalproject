package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

/**
 * TopicService.java - an interface of topic service.
 * Defines methods for retrieving topic data from repository.
 *
 * @author  Vitalii Chereshnia
 * @version 1.0
 * @see     Topic
 */
public interface TopicService {

    /**
     * Returns the number of existing topics.
     *
     * @return a number of topics
     */
    int getTopicsCount();

    /**
     * Returns a list of existing topics, excluding a specified number of previous records.
     * Result list's size will always be less than or equals to specified limit.
     *
     * @param limit a maximum number of topics to return
     * @param offset a number of previous records of topics to skip
     * @return the List object parameterized by Topic, or null if there was en error reading from repository
     */
    List<Topic> getAllTopics(int limit, int offset);
}
