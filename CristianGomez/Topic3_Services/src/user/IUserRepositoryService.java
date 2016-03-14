package user;

import java.util.List;

/**
 * @author Cadrian A user service for CRUD operations. Lets you create, read,
 *         update and delete users from a repository.
 */
public interface IUserRepositoryService {

    /**
     * Save a user on the repository. If the user exists, its updated. If not,
     * its added to the repo. Usernames must be unique.
     * 
     * @param user
     *            to be saved.
     */
    public void saveUser(User user);

    /**
     * Get a user by its unique id key.
     * 
     * @param userId
     *            The id of the wanted user.
     * @return A User object.
     */
    public User getUserById(int userId);

    /**
     * Get all the users from the repository.
     * 
     * @return A list with the User objects.
     */
    public List<User> getAllUsers();

    /**
     * Deletes a User from the repository.
     * 
     * @param userId
     *            The id of the user to be deleted.
     * @return True if the User was deleted.
     */
    public boolean deleteUser(int userId);

}
