package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopicById(int id);
}
