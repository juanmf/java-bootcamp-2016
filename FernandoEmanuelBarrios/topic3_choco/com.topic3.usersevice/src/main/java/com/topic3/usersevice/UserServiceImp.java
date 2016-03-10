package com.topic3.usersevice;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements IUserService {
	List<User> users;

	public UserServiceImp() {
		users = new ArrayList<User>();
	}

	@Override
	public void addUser(User user) {
		if (!users.contains(user))
			users.add(user);

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
	public void updateUser(User user, String nickName, String psw) {
		User aUser = users.get(users.indexOf(user));
		aUser.setNickName(nickName);
		aUser.setPsw(psw);
	}

	@Override
	public List<User> listUsers() {

		return users;
	}

	
}
