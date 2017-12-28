package ua.training.vitascherry.model.service;

import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.Topic;

import java.util.List;

public class TopicService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    private static volatile TopicService topicService;

    private TopicService() {}

    public static TopicService getInstance(){
        if( topicService == null ){
            synchronized (TopicService.class){
                if( topicService == null ){
                    topicService = new TopicService();
                }
            }
        }
        return topicService;
    }

    public List<Topic> getAllTopics() {
        try (TopicDao dao = daoFactory.createTopicDao()) {
            return dao.findAll();
        }
    }
}
