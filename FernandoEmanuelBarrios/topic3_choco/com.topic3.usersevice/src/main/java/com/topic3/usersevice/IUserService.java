package com.topic3.usersevice;

import java.util.List;

public interface IUserService {
	public void addUser(User user);

	public boolean removeUser(User user);

	public void updateUser(User user, String nickName, String psw);

	public List<User> listUsers();


}
