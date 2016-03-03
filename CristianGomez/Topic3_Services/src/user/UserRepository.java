package user;

import java.util.ArrayList;
import java.util.List;

/**@author Cadrian
 * Local implementation of the User Repository Service.
 */
public class UserRepository implements IUserRepositoryService {

    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<User>();
    }

    public void saveUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser == null)
            users.add(user);
        else
            existingUser.update(user);
    }

    public User getUserById(int userId) {
        for (User user : users)
            if (user.getId() == userId)
                return user;
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public boolean deleteUser(int userId) {
        User existingUser = getUserById(userId);
        if (existingUser == null)
            return false;
        else {
            users.remove(existingUser);
            return true;
        }
    }

}
