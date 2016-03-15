package com.userservice;

/**
 * @author cota
 *
 */
public class Main {

	public static void main(String[] args) {
		User user = new User("Cota", "alagrandelepusecuca");
		IUserService service;
		service = ServiceUserFactory.getUserServiceDesktop();
		service.addUser(user);
		
		for (User usr : service.listUsers()) {
			System.out.println(usr);
		}
	}

}
