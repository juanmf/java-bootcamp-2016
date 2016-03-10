package com.userservice;

import java.util.List;


/**
 * @author cota
 *
 */
public class WebUserService implements IUserService {

	IUserService web;

	public WebUserService() {
		// web = code to get the reference to IUserService from the web call
	}

	@Override
	public void addUser(User user) {
		web.addUser(user);

	}

	@Override
	public boolean removeUser(User user) {
		return web.removeUser(user);
	}

	@Override
	public void updateUser(User user, String nickName, String psw) {
		web.updateUser(user, nickName, psw);

	}

	@Override
	public List<User> listUsers() {
		return web.listUsers();
	}

}
