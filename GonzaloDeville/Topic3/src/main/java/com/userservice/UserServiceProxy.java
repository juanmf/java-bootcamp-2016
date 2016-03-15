package com.userservice;

import java.util.List;

/**
 * @author cota
 *
 */
public class UserServiceProxy implements IUserService {

	private IUserService user;

	public UserServiceProxy(IUserService user) {
		this.user = user;
	}

	@Override
	public void addUser(User user) {
		this.user.addUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		return this.user.removeUser(user);

	}

	@Override
	public void updateUser(User user, String nickName, String psw) {
		this.user.updateUser(user, nickName, psw);
	}

	@Override
	public List<User> listUsers() {
		return this.user.listUsers();
	}

}

