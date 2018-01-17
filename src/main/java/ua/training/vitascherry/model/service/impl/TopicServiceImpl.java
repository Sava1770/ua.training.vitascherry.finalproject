package ua.training.vitascherry.model.service.impl;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.dao.query.QueryOption;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.TopicService;

import java.util.List;

import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;

public class TopicServiceImpl implements TopicService {

    private DaoFactory daoFactory;

    public TopicServiceImpl(DaoFactory factory) {
        this.daoFactory = factory;
    }

    @Override
    public List<Topic> getAllTopics(int offset) {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findAll(QueryOption.create(RECORDS_PER_PAGE, offset));
        }
    }

    @Override
    public List<Topic> getAllTopics() {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findAll();
        }
    }

    @Override
    public Topic getTopicById(int id) {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findById(id);
        }
    }

    @Override
    public Topic getTopicById(int id, int offset) {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findById(id, QueryOption.create(RECORDS_PER_PAGE, offset));
        }
    }
}
