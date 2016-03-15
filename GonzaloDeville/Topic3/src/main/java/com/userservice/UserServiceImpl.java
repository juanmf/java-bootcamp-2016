package com.userservice;

import java.util.ArrayList;
import java.util.List;


/**
 * @author cota
 *
 */
public class UserServiceImpl implements IUserService {
	List<User> users;

	public UserServiceImpl() {
		users = new ArrayList<User>();
	}

	/* 
	 * This implementation it doen't allow add a repeated user.
	 */
	@Override
	public void addUser(User user) {
		if(!users.contains(user)){
			users.add(user);
		}else{
			System.out.println("User already exist, please try again");
		}
	}

	@Override
	public boolean removeUser(User user) {
		if (users.contains(user)) {
			int UserNbr = users.indexOf(user);
			users.remove(UserNbr);
			return true;
		}
		return false;
	}

	@Override
	public void updateUser(User user, String usrName, String psw) {
		User aUser = users.get(users.indexOf(user));
		aUser.setUserName(usrName);
		aUser.setPsw(psw);
	}

	@Override
	public List<User> listUsers() {
		return users;
	}
	

	
}
