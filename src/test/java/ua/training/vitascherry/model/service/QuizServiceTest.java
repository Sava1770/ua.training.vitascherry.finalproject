package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Quiz;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuizServiceTest {
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
            .when(daoMock.findAll())
            .thenReturn(sampleQuizzes);

        QuizService service = new QuizService(factoryMock);

        List<Quiz> result = service.getAllQuizzes();

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findAll();
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
            .when(daoMock.findAllPassedByStudent(studentId))
            .thenReturn(passedQuizzes);

        QuizService service = new QuizService(factoryMock);

        List<Quiz> result = service.getAllPassedByStudentId(studentId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findAllPassedByStudent(studentId);
        Mockito.verify(daoMock).close();

        assertThat(result, is(passedQuizzes));
    }

    @Test
    public void getAllAvailableForStudent() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        int studentId = 3;
        List<Quiz> availableQuizzes = Arrays.asList(
                Quiz.builder().setId(1).build(),
                Quiz.builder().setId(2).build()
        );

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAllAvailableForStudent(studentId))
            .thenReturn(availableQuizzes);

        QuizService service = new QuizService(factoryMock);

        List<Quiz> result = service.getAllAvailableForStudent(studentId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findAllAvailableForStudent(studentId);
        Mockito.verify(daoMock).close();

        assertThat(result, is(availableQuizzes));
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

        QuizService service = new QuizService(factoryMock);

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

        QuizService service = new QuizService(factoryMock);

        Quiz result = service.getQuizResult(studentId, quizId);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).findByStudentIdQuizId(studentId, quizId);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleQuiz));
    }

}