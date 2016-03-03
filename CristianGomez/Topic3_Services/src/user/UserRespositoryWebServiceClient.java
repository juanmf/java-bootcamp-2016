package user;

import java.util.List;

/**
 * An implementation of the User Repository Service API to access it from a web service.
 */
public class UserRespositoryWebServiceClient implements IUserRepositoryService {

    IUserRepositoryService webservice;

    public UserRespositoryWebServiceClient() {
        // webService = code to get the reference to Service A from the
        // webservice call.
    }

    public void saveUser(User user) {
        webservice.saveUser(user);
    }

    public User getUserById(int userId) {
        return webservice.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return getAllUsers(); 
    }

    public boolean deleteUser(int userId) {
        return deleteUser(userId); 
    }

}
