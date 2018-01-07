package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class StudentAnswerServiceTest {
    @Test
    public void createStudentAnswers() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        int studentId = 3;
        List<Integer> answerIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.createStudentAnswers(studentId, answerIds))
            .thenReturn(answerIds.size());

        StudentAnswerService service = new StudentAnswerService(factoryMock);

        // Test response when server method wasn't called yet
        Response response = service.getResponse();
        assertNull(response);

        // Calling service method
        service.createStudentAnswers(studentId, answerIds);

        // Test response when server method was called and succeeded
        response = service.getResponse();
        assertThat(response, is(Response.QUIZ_RESULT));

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).createStudentAnswers(studentId, answerIds);
        Mockito.verify(daoMock).close();
    }
}