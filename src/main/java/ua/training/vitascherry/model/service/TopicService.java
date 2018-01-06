package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public class TopicService {

    private DaoFactory daoFactory;

    public TopicService(DaoFactory factory) {
        this.daoFactory = factory;
    }

    public List<Topic> getAllTopics() {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findAll();
        }
    }

    public Topic getTopicById(int id) {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findById(id);
        }
    }
}
