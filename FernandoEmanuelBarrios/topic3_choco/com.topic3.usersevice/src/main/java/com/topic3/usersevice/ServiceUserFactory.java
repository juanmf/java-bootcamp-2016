package com.topic3.usersevice;

public class ServiceUserFactory {

	public ServiceUserFactory() {

	}

	public static IUserService getUserServiceDesktop() {
		return new UserServiceProxy(new UserServiceImp());
	}

	public static IUserService getUserServiceWeb() {
		return new UserServiceProxy(new WebUserService());
	}
}
