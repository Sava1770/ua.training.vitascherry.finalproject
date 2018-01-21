package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;
import ua.training.vitascherry.model.service.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static ua.training.vitascherry.controller.util.Constants.DEFAULT_OFFSET;
import static ua.training.vitascherry.controller.util.Constants.RECORDS_PER_PAGE;

public class UserServiceTest {

    @Test
    public void getStudentsCount() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        final int sampleCount = 5;

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.getStudentsCount())
            .thenReturn(sampleCount);

        UserService service = new UserServiceImpl(factoryMock);

        int result = service.getStudentsCount();

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).getStudentsCount();
        Mockito.verify(daoMock).close();

        //Test equals
        assertThat(result, is(sampleCount));
    }

    @Test
    public void createUser() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        User sampleUser = User.builder()
            .setId(2)
            .setEmail("test")
            .setRole(User.Role.STUDENT).setPasswordHash("test")
            .setFirstName("test").setLastName("test").setPatronymic("test")
            .build();

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.create(sampleUser))
            .thenReturn(1);

        UserService service = new UserServiceImpl(factoryMock);

        boolean isCreated = service.createUser(sampleUser);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).create(sampleUser);
        Mockito.verify(daoMock).close();

        assertTrue(isCreated);
    }

    @Test
    public void isUniqueEmail() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        User sampleUser = User.builder()
            .setId(2)
            .setEmail("test.test@test.com")
            .setRole(User.Role.STUDENT).setPasswordHash("test")
            .setFirstName("test").setLastName("test").setPatronymic("test")
            .build();

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findByEmail(sampleUser.getEmail()))
            .thenReturn(sampleUser);

        UserService service = new UserServiceImpl(factoryMock);

        boolean result = service.isUniqueEmail(sampleUser.getEmail());

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findByEmail(sampleUser.getEmail());
        Mockito.verify(daoMock).close();

        assertFalse(result);
    }

    @Test
    public void getUserByEmail() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        User sampleUser = User.builder()
            .setId(2)
            .setEmail("test.test@gmail.com")
            .build();

        final String missingEmail = "missing.email@gmail.com";

        Mockito
            .when(factoryMock.createUserDao())
            .thenReturn(daoMock);

        Mockito
            .when(daoMock.findByEmail(sampleUser.getEmail()))
            .thenReturn(sampleUser);

        UserService service = new UserServiceImpl(factoryMock);

        User existingUser = service.getUserByEmail(sampleUser.getEmail());

        User missingUser = service.getUserByEmail(missingEmail);

        Mockito.verify(factoryMock, Mockito.times(2)).createUserDao();
        Mockito.verify(daoMock).findByEmail(sampleUser.getEmail());
        Mockito.verify(daoMock).findByEmail(missingEmail);
        Mockito.verify(daoMock, Mockito.times(2)).close();

        assertThat(sampleUser, is(existingUser));

        assertNull(missingUser);
    }

    @Test
    public void isValidCredentials() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);

        User sampleUser = User.builder()
            .setId(1)
            .setEmail("test.test@gmail.com")
            .setPasswordHash("5f4dcc3b5aa765d61d8327deb882cf99")
            .setRole(User.Role.STUDENT)
            .build();
        String correctPassword = "password";
        String incorrectPassword = "123456";

        UserService service = new UserServiceImpl(factoryMock);

        boolean validCredentials = service.isValidCredentials(sampleUser, correctPassword);
        boolean invalidCredentials = service.isValidCredentials(sampleUser, incorrectPassword);

        assertTrue(validCredentials);
        assertFalse(invalidCredentials);
    }

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
            .when(daoMock.findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET))
            .thenReturn(sampleUsers);

        UserServiceImpl service = new UserServiceImpl(factoryMock);

        List<User> result = service.getAllStudents(RECORDS_PER_PAGE, DEFAULT_OFFSET);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findAll(RECORDS_PER_PAGE, DEFAULT_OFFSET);
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

        UserServiceImpl service = new UserServiceImpl(factoryMock);

        User result = service.getStudentById(id);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findById(id);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleUser));
    }
}
