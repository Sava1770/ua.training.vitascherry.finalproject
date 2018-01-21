package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.QuizDao;
import ua.training.vitascherry.model.entity.Question;
import ua.training.vitascherry.model.entity.Quiz;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.impl.SolutionServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionServiceTest {

    @Test
    public void createStudentAnswers() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        QuizDao daoMock = Mockito.mock(QuizDao.class);

        User student = User.builder().setId(3).build();
        List<Question> questions = Arrays.asList(
            Question.builder().setId(1).build(),
            Question.builder().setId(2).build(),
            Question.builder().setId(3).build(),
            Question.builder().setId(4).build(),
            Question.builder().setId(5).build()
        );
        Quiz quiz = Quiz.builder().setId(1).setQuestions(questions).build();

        Mockito
            .when(factoryMock.createQuizDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.createStudentSolution(student, quiz))
            .thenReturn(questions.size());

        SolutionService service = new SolutionServiceImpl(factoryMock);

        boolean isCreated = service.createStudentSolution(student, quiz);

        Mockito.verify(factoryMock).createQuizDao();
        Mockito.verify(daoMock).createStudentSolution(student, quiz);
        Mockito.verify(daoMock).close();

        assertTrue(isCreated);
    }
}
