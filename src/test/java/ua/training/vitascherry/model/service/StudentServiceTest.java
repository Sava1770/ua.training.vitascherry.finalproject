package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentServiceTest {
    @Test
    public void getAllStudents() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        List<User> sampleUsers = Arrays.asList(
                User.builder().setId(1).setRole(User.Role.STUDENT).build(),
                User.builder().setId(2).setRole(User.Role.STUDENT).build()
        );

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findAll())
            .thenReturn(sampleUsers);

        StudentService service = new StudentService(factoryMock);

        List<User> result = service.getAllStudents();

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findAll();
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleUsers));
    }

    @Test
    public void getStudentById() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        final int id = 1;
        User sampleUser = User.builder().setId(id).build();

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findById(id))
            .thenReturn(sampleUser);

        StudentService service = new StudentService(factoryMock);

        User result = service.getStudentById(id);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findById(id);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleUser));
    }

}