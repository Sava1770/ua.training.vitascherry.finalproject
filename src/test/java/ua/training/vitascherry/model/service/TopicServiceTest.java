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
import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;

@RunWith(MockitoJUnitRunner.class)
public class TopicServiceTest {

    @Test
    public void getTopicsCount() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        TopicDao daoMock = Mockito.mock(TopicDao.class);

        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createTopicDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getTopicsCount())
            .thenReturn(sampleCount);

        TopicService service = new TopicServiceImpl(factoryMock);

        int result = service.getTopicsCount();

        Mockito.verify(factoryMock).createTopicDao();
        Mockito.verify(daoMock).getTopicsCount();
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void getAllTopics() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        TopicDao daoMock = Mockito.mock(TopicDao.class);

        List<Topic> sampleTopics = Arrays.asList(
            Topic.builder().setId(1).setName("Beginner Test").build(),
            Topic.builder().setId(2).setName("Other test").build()
        );

        Mockito
            .when(factoryMock.createTopicDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleTopics);

        TopicService service = new TopicServiceImpl(factoryMock);

        List<Topic> result = service.getAllTopics(RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createTopicDao();
        Mockito.verify(daoMock).findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleTopics));
    }
}
