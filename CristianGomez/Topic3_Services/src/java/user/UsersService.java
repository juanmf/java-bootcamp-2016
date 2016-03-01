package java.user;

/**
 * Interface that defines what a User service must do.
 * @author Adrian Gomez
 * @version 1.0
 * @since 1.0
 *
 */
public interface UsersService {
    public void createUser(User u);

    public void updateUser(User u);

    public void removeUser(User u);

    public User findUser(User u);

    public boolean login(User u);

    public boolean logout(User u);

}