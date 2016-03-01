package java.user;

import java.site.Site;
import java.util.Iterator;

/**
 * Implementation of the UserService interface.
 * @author Adrian Gomez
 * @version 1.0
 * @since 1.0
 *
 */

public class UsersServiceImpl implements UsersService {
    /**
     * Class variable that retrieves the instance of the Site (database mock).
     */
    Site s;

    /**
     * Class constructor.
     */
    public UsersServiceImpl() {
        s = Site.getInstance();
    }
/**
 * Adds a User to the database.
 */
    public void createUser(User u) {
        s.getUsers().add(u);

    }
/**
 * Updates a User in the database.
 */
    public void updateUser(User u) {
        if (s.getUsers().contains(u)) {
            s.getUsers().remove(u);
            s.getUsers().add(u);
        } else {
            s.getUsers().add(u);
        }

    }
    /**
     * Removes a User from the database.
     */

    public void removeUser(User u) {
        if (s.getUsers().contains(u)) {
            s.getUsers().remove(u);
        }

    }
    /**
     * Searches for a User in the database.
     * 
     * @return The user if its found in the database, null if it can't be found.
     */
    public User findUser(User u) {
        Iterator<User> it = s.getUsers().iterator();
        while(it.hasNext()) {
            User aux = (User) it.next();
            if(aux.equals(u)) {
                return aux; 
            }
        }
        return null;

    }
    /**
     * Logs in the user into the Site if his credentials are valid.
     * @return true if the user logs in successfully.
     */

    public boolean login(User u) {
        Iterator<User> it = s.getUsers().iterator();
        while(it.hasNext()) {
            User aux = (User) it.next();
            if(aux.equals(u)) {
                if(aux.getPassword().compareTo(u.getPassword()) == 0) {
                    aux.setLoggedIn(true);
                    return true;
                }
            }
        }
        return false;       

    }
    /**
     * Logs out the user out of the Site.
     * @return true if the user logs out successfully.
     */
    public boolean logout(User u) {
        Iterator<User> it = s.getUsers().iterator();
        while(it.hasNext()) {
            User aux = (User) it.next();
            if(aux.equals(u)) {
                    aux.setLoggedIn(false);
                    return true;
            }
        }
        return false;   
    }

}