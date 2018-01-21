package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.entity.StudentProgress;
import ua.training.vitascherry.model.service.impl.StudentProgressServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;

public class StudentProgressServiceTest {

    @Test
    public void getProgressesCount() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        StudentProgressDao daoMock = Mockito.mock(StudentProgressDao.class);

        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createStudentProgressDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getProgressesCount())
            .thenReturn(sampleCount);

        StudentProgressService service = new StudentProgressServiceImpl(factoryMock);

        int result = service.getProgressesCount();

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).getProgressesCount();
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void getProgressesCountByStudentId() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        StudentProgressDao daoMock = Mockito.mock(StudentProgressDao.class);

        final int sampleId = 2;
        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createStudentProgressDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getProgressesCountByStudent(sampleId))
            .thenReturn(sampleCount);

        StudentProgressService service = new StudentProgressServiceImpl(factoryMock);

        int result = service.getProgressesCountByStudentId(sampleId);

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).getProgressesCountByStudent(sampleId);
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void getAllProgresses() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        StudentProgressDao daoMock = Mockito.mock(StudentProgressDao.class);

        List<StudentProgress> sampleProgresses = Arrays.asList(
            StudentProgress.builder()
                .setQuiz(Quiz.builder().setId(1).build())
                .setStudent(User.builder().setId(2).build())
                .setCorrectCount(10).setQuestionCount(12).build(),
            StudentProgress.builder()
                .setQuiz(Quiz.builder().setId(1).build())
                .setStudent(User.builder().setId(3).build())
                .setCorrectCount(12).setQuestionCount(12).build(),
            StudentProgress.builder()
                .setQuiz(Quiz.builder().setId(1).build())
                .setStudent(User.builder().setId(4).build())
                .setCorrectCount(5).setQuestionCount(12).build()
        );

        Mockito
            .when(factoryMock.createStudentProgressDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleProgresses);

        StudentProgressService service = new StudentProgressServiceImpl(factoryMock);

        List<StudentProgress> result = service.getAllProgresses(RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleProgresses));
    }

    @Test
    public void getProgressesByStudentId() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        StudentProgressDao daoMock = Mockito.mock(StudentProgressDao.class);

        List<StudentProgress> sampleProgresses = Collections.singletonList(
            StudentProgress.builder()
                .setQuiz(Quiz.builder().setId(1).build())
                .setStudent(User.builder().setId(1).build())
                .setCorrectCount(10).setQuestionCount(12).build()
        );

        Mockito
            .when(factoryMock.createStudentProgressDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findByStudentId(1, RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleProgresses);

        StudentProgressService service = new StudentProgressServiceImpl(factoryMock);

        List<StudentProgress> result = service.getProgressesByStudentId(1, RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).findByStudentId(1, RECORDS_PER_PAGE, DEFAULT_OFFSET);
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleProgresses));
    }
}
