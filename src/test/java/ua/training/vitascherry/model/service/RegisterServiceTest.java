package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RegisterServiceTest {
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

        RegisterService service = new RegisterService(factoryMock);

        // Test response when server method wasn't called yet
        Response response = service.getResponse();
        assertNull(response);

        // Calling service method
        service.createUser(sampleUser);

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).create(sampleUser);
        Mockito.verify(daoMock).close();

        // Test response when server method was called and succeeded
        response = service.getResponse();
        assertThat(response, is(Response.REGISTER_SUCCESS));
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

        RegisterService service = new RegisterService(factoryMock);

        // Test response when server method wasn't called yet
        Response response = service.getResponse();
        assertNull(response);

        // Calling service method
        boolean result = service.isUniqueEmail(sampleUser.getEmail());

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findByEmail(sampleUser.getEmail());
        Mockito.verify(daoMock).close();

        assertFalse(result);

        // Test response when server method was called and succeeded
        response = service.getResponse();
        assertThat(response, is(Response.REGISTER));
    }

}