package com.topic3.usersevice;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		User user=new User("choco", "unodostres");
		IUserService service;
		service = ServiceUserFactory.getUserServiceDesktop();
		service.addUser(user);
		Iterator<User> it = service.listUsers().iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}
