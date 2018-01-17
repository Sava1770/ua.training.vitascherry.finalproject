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
import static org.junit.Assert.assertThat;

public class UserServiceTest {

    @Test
    public void createUser() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);
        UserDao daoMock = Mockito.mock(UserDao.class);

        User sampleUser = User.builder().setId(2).setEmail("test")
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

        User sampleUser = User.builder().setId(2).setEmail("test.test@test.com")
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

        User sampleUser = User.builder().setId(2).setEmail("test")
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

        User result = service.getUserByEmail(sampleUser.getEmail());

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findByEmail(sampleUser.getEmail());
        Mockito.verify(daoMock).close();

        assertThat(sampleUser, is(result));
    }

    @Test
    public void isValidCredentials() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);

        User sampleUser = User.builder().setId(1).setEmail("test.test@gmail.com")
                .setPasswordHash("5f4dcc3b5aa765d61d8327deb882cf99")
                .setRole(User.Role.STUDENT).build();
        String password = "password";

        UserService service = new UserServiceImpl(factoryMock);

        boolean result = service.isValidCredentials(sampleUser, password);

        assertTrue(result);
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
                .when(daoMock.findAll())
                .thenReturn(sampleUsers);

        UserServiceImpl service = new UserServiceImpl(factoryMock);

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

        UserServiceImpl service = new UserServiceImpl(factoryMock);

        User result = service.getStudentById(id);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findById(id);
        Mockito.verify(daoMock).close();

        assertThat(result, is(sampleUser));
    }

}