package com.bootcamp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bootcamp.FinalProject.App;
import com.bootcamp.FinalProject.controller.SiteController;
import com.bootcamp.FinalProject.controller.UserController;
import com.bootcamp.FinalProject.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SiteControllerTest {
    
    @Autowired
    private SiteController siteController;
    
    @Autowired
    private UserController userController;
    
    private User user;

    @Before
    public void loadData() {
        user = new User();
        user.setFirstName("Jon");
        user.setLastName("Snow");
        user.setUsername("JonSnow");
        user.setPassword("ForTheWatch");
        userController.addUser(user);
    }

    @After
    public void deleteData() {
        userController.deleteUser(user.getUsername());
    }

    @Test
    public void loginAndLogoutSuccessfulTest() {
        assertEquals("Login successful", siteController.login(user));
        assertEquals("Logout successful", siteController.logout(user.getUsername()));
    }

    @Test
    public void loginUnsuccessfulTest() {
        user.setPassword("123");
        assertNotSame("Login successful", siteController.login(user));

    }

    @Test
    public void logoutWithWrongUserNameTest() {
        assertEquals("Login successful", siteController.login(user));
        user.setUsername("Cosme");
        assertNotSame("Logout successful", siteController.logout(user.getUsername()));
        user.setUsername("JonSnow");
        assertEquals("Logout successful", siteController.logout(user.getUsername()));
    }

    @Test
    public void logoutWhenAlreadyLoggetOutTest() {
        assertEquals("Login successful", siteController.login(user));
        assertEquals("Logout successful", siteController.logout(user.getUsername()));
        assertNotSame("Logout successful", siteController.logout(user.getUsername()));
    }
}
