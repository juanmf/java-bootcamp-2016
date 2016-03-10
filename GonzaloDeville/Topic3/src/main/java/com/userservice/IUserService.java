package com.userservice;

import java.util.List;

/**
 * @author cota
 *
 */
public interface IUserService {

	/**
	 * The implementation of this method allows add an user to a list
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * The implementation of this method allows remove an a selected user from a list
	 * @param user
	 * @return True if it's possible remove the selected user
	 */
	public boolean removeUser(User user);

	/**
	 * The implementation of this method allows modify the parameters of an selected User.
	 * @param user
	 * @param userName
	 * @param psw
	 */
	public void updateUser(User user, String userName, String psw);

	/**
	 * The implementation of this method returns a list of users.
	 * @return a List of users.
	 */
	public List<User> listUsers();

}
