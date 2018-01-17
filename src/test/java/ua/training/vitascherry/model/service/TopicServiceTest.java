package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.TopicDao;
import ua.training.vitascherry.model.entity.Topic;
import ua.training.vitascherry.model.service.impl.TopicServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceTest {

    @Test
    public void getAllTopics() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        TopicDao daoMock = Mockito.mock(TopicDao.class);

        List<Topic> sampleTopics = Arrays.asList(
                Topic.builder().setId(1).setName("Beginner Test").build(),
                Topic.builder().setId(2).setName("Other test").build());

        Mockito
            .when(factoryMock.createTopicDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAll())
            .thenReturn(sampleTopics);

        TopicService service = new TopicServiceImpl(factoryMock);

        List<Topic> result = service.getAllTopics();

        Mockito.verify(factoryMock).createTopicDao();
        Mockito.verify(daoMock).findAll();
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleTopics));
    }

    @Test
    public void getTopicById() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        TopicDao daoMock = Mockito.mock(TopicDao.class);

        final int id = 1;
        Topic sampleTopic = Topic.builder().setId(id).setName("Beginner Test").build();

        Mockito
            .when(factoryMock.createTopicDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findById(id))
            .thenReturn(sampleTopic);

        TopicService service = new TopicServiceImpl(factoryMock);

        Topic result = service.getTopicById(id);

        Mockito.verify(factoryMock).createTopicDao();
        Mockito.verify(daoMock).findById(id);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleTopic));
    }
}
