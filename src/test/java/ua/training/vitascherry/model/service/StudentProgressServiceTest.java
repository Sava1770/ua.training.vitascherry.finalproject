package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.StudentProgressDao;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.entity.StudentProgress;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class StudentProgressServiceTest {
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
            .when(daoMock.findAll())
            .thenReturn(sampleProgresses);

        StudentProgressService service = new StudentProgressService(factoryMock);

        List<StudentProgress> result = service.getAllProgresses();

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).findAll();
        Mockito.verify(daoMock).close();

        // Test size
        assertThat(result, hasSize(3));

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
                .when(daoMock.findByStudentId(1))
                .thenReturn(sampleProgresses);

        StudentProgressService service = new StudentProgressService(factoryMock);

        List<StudentProgress> result = service.getProgressesByStudentId(1);

        Mockito.verify(factoryMock).createStudentProgressDao();
        Mockito.verify(daoMock).findByStudentId(1);
        Mockito.verify(daoMock).close();

        // Test size
        assertThat(result, hasSize(1));

        //Test equals
        assertThat(result, is(sampleProgresses));
    }

}