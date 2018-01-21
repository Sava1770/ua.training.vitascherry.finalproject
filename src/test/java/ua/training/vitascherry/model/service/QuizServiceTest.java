package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.service.impl.QuizServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;

public class QuizServiceTest {

    @Test
    public void getQuizzesCount() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getQuizzesCount())
            .thenReturn(sampleCount);

        QuizService service = new QuizServiceImpl(factoryMock);

        int result = service.getQuizzesCount();

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).getQuizzesCount();
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void getQuizzesCountRelatedToTopic() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        final int sampleId = 2;
        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getQuizzesCountByTopic(sampleId))
            .thenReturn(sampleCount);

        QuizService service = new QuizServiceImpl(factoryMock);

        int result = service.getRelatedQuizzesCount(sampleId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).getQuizzesCountByTopic(sampleId);
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void getAllRelatedToTopic() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        final int topicId = 1;
        List<Quiz> sampleQuizzes = Arrays.asList(
            Quiz.builder().setId(1).build(),
            Quiz.builder().setId(2).build()
        );

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findByTopicId(topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleQuizzes);

        QuizService service = new QuizServiceImpl(factoryMock);

        List<Quiz> result = service.getAllRelatedToTopic(topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findByTopicId(topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuizzes));
    }

    @Test
    public void getAllQuizzes() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        List<Quiz> sampleQuizzes = Arrays.asList(
            Quiz.builder().setId(1).build(),
            Quiz.builder().setId(2).build()
        );

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleQuizzes);

        QuizService service = new QuizServiceImpl(factoryMock);

        List<Quiz> result = service.getAllQuizzes(RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuizzes));
    }

    @Test
    public void getAllPassedByStudentId() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        int studentId = 3;
        List<Quiz> passedQuizzes = Arrays.asList(
            Quiz.builder().setId(1).build(),
            Quiz.builder().setId(2).build()
        );

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findPassedByStudentId(studentId))
            .thenReturn(passedQuizzes);

        QuizService service = new QuizServiceImpl(factoryMock);

        List<Quiz> result = service.getAllPassedByStudent(studentId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findPassedByStudentId(studentId);
        Mockito.verify(daoMock).close();

        assertThat(result, is(passedQuizzes));
    }

    @Test
    public void getAllAvailableForStudent() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        int studentId = 3;
        int topicId = 1;
        List<Quiz> sampleQuizzes = Arrays.asList(
            Quiz.builder().setId(1).build(),
            Quiz.builder().setId(2).build()
        );

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAvailableByStudentIdTopicId(studentId, topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleQuizzes);

        QuizService service = new QuizServiceImpl(factoryMock);

        List<Quiz> result = service.getAllAvailableForStudent(studentId, topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findAvailableByStudentIdTopicId(studentId, topicId, RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuizzes));
    }

    @Test
    public void getQuizById() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        final int id = 1;
        Quiz sampleQuiz = Quiz.builder().setId(id).build();

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findById(id))
            .thenReturn(sampleQuiz);

        QuizService service = new QuizServiceImpl(factoryMock);

        Quiz result = service.getQuizById(id);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findById(id);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuiz));
    }

    @Test
    public void getQuizResult() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        final int studentId = 3;
        final int quizId = 1;
        Quiz sampleQuiz = Quiz.builder().setId(quizId).build();

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findByStudentIdQuizId(studentId, quizId))
            .thenReturn(sampleQuiz);

        QuizService service = new QuizServiceImpl(factoryMock);

        Quiz result = service.getStudentQuizSolution(studentId, quizId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findByStudentIdQuizId(studentId, quizId);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuiz));
    }
}
