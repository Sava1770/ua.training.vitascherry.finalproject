package ua.training.vitascherry.model.service;

import org.junit.Test;
import org.mockito.Mockito;
import ua.training.vitascherry.controller.util.Response;
import ua.training.vitascherry.model.dao.DaoFactory;
import ua.training.vitascherry.model.dao.UserDao;
import ua.training.vitascherry.model.entity.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SignInServiceTest {
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

        SignInService service = new SignInService(factoryMock);

        // Test response when server method wasn't called yet
        Response response = service.getResponse();
        assertNull(response);

        // Calling service method
        User result = service.getUserByEmail(sampleUser.getEmail());

        Mockito.verify(factoryMock).createUserDao();
        Mockito.verify(daoMock).findByEmail(sampleUser.getEmail());
        Mockito.verify(daoMock).close();

        assertThat(sampleUser, is(result));

        // Test response when server method was called and succeeded
        response = service.getResponse();
        assertThat(response, is(sampleUser.getRole().getSignInResponse()));
    }

    @Test
    public void isValidCredentials() throws Exception {
        DaoFactory factoryMock = Mockito.mock(DaoFactory.class);

        User sampleUser = User.builder().setId(1).setEmail("test.test@gmail.com")
                .setPasswordHash("5f4dcc3b5aa765d61d8327deb882cf99")
                .setRole(User.Role.STUDENT).build();
        String password = "password";

        SignInService service = new SignInService(factoryMock);

        // Test response when server method wasn't called yet
        Response response = service.getResponse();
        assertNull(response);

        // Calling service method
        boolean result = service.isValidCredentials(sampleUser, password);

        assertTrue(result);

        // Test response when server method was called and succeeded
        response = service.getResponse();
        assertThat(response, is(sampleUser.getRole().getSignInResponse()));
    }

}