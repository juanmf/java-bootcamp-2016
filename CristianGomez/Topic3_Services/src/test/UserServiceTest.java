package test;

import static org.junit.Assert.*;

import java.user.User;
import java.user.UsersService;
import java.user.UsersServiceImpl;

import org.junit.Test;

public class UserServiceTest {

    @Test
    public void createUserTest() {
        UsersService userService = new UsersServiceImpl();
        User u = new User("Edward", "Salgueiro", "edwarx", "lalala", null);
        userService.createUser(u);
        assertNotNull(u);
        assertTrue(u.equals(userService.findUser(u)));
    }

    @Test
    public void updateUserTest() {
        UsersService userService = new UsersServiceImpl();
        User u = new User("Edward", "Salgueiro", "edwarx", "lalala", null);
        userService.createUser(u);
        u = new User("edwarx");
        u = userService.findUser(u);
        assertNotNull(u);
        u.setFirstName("Eduardo");
        userService.updateUser(u);
        assertEquals("Eduardo", userService.findUser(u).getFirstName());
    }

    @Test
    public void loginTest() {
        UsersService userService = new UsersServiceImpl();
        User u = new User("Eduardo", "Salgueiro", "edwarx", "password", null);
        userService.createUser(u);
        assertFalse(userService.login(new User("edwarx", "lalala")));
        assertTrue(userService.login(new User("edwarx", "password")));
    }

    @Test
    public void logoutTest() {
        UsersService userService = new UsersServiceImpl();
        User u = new User("Eduardo", "Salgueiro", "edwarx", "password", null);
        userService.createUser(u);
        userService.login(new User("edwarx", "password"));
        assertFalse(userService.logout(new User("edwarx", "lalala")));
        assertTrue(userService.logout(new User("edwarx", "password")));
    }
}