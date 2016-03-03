package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import user.IUserRepositoryService;
import user.User;
import user.UserRepositoryFactory;

public class UserRepositoryTest {

    private IUserRepositoryService userRepoService;

    @Before
    public void setUp() {
        this.userRepoService = UserRepositoryFactory.getLocalUserRespository();
    }

    /**
     * Tests cases: WHEN new user THEN add user. WHEN existing user THEN update
     * user and not duplicate.
     */
    @Test
    public void testSaveUser() {
        User user1 = new User("Cosme", "pass");
        userRepoService.saveUser(user1);
        List<User> users = userRepoService.getAllUsers();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("Cosme", users.get(0).getName());

        user1.setPasswd("secure");
        userRepoService.saveUser(user1);
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("Cosme", users.get(0).getName());
    }

    /**
     * WHEN getAllUsers() THEN return list of all Users added to repo.
     */
    @Test
    public void testGetAllUsers() {
        User userX;
        List<User> test_list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            userX = new User("User " + i, "User pass" + i);
            userRepoService.saveUser(userX);
            test_list.add(userX);
        }

        Assert.assertEquals(10, userRepoService.getAllUsers().size());
        Assert.assertTrue(userRepoService.getAllUsers().containsAll(test_list));
    }

    /**
     * WHEN deleteUser THEN user is removed from repository. WHEN delete
     * existing user THEN return true. WHEN delete non existing user THEN return
     * false.
     */
    @Test
    public void testDeleteUser() {
        User user1 = new User("Cosme", "pass");
        userRepoService.saveUser(user1);
        boolean result = userRepoService.deleteUser(user1.getId());
        Assert.assertFalse(userRepoService.getAllUsers().contains(user1));
        Assert.assertTrue(result);

        User user2 = new User("Fulanito", "pass");
        result = userRepoService.deleteUser(user2.getId());
        Assert.assertFalse(result);
    }
}
