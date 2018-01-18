package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public interface TopicService {

    int getTopicsCount();

    int getQuizzesCountByTopicId(int id);

    List<Topic> getAllTopics();

    List<Topic> getAllTopics(int offset);

    Topic getTopicById(int id);

    Topic getTopicById(int id, int offset);
}
