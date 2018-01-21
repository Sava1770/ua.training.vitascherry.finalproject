package ua.training.vitascherry.model.service.impl;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private DaoFactory daoFactory;

    public TopicServiceImpl(DaoFactory factory) {
        this.daoFactory = factory;
    }

    @Override
    public int getTopicsCount() {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.getTopicsCount();
        }
    }

    @Override
    public List<Topic> getAllTopics(int limit, int offset) {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findAll(limit, offset);
        }
    }
}
