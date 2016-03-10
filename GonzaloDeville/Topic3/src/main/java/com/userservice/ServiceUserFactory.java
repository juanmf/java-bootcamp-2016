package com.userservice;

/**
 * @author cota
 *
 */
public class ServiceUserFactory {
	public ServiceUserFactory() {

	}

	public static IUserService getUserServiceDesktop() {
		return new UserServiceProxy(new UserServiceImpl());
	}

	public static IUserService getUserServiceWeb() {
		return new UserServiceProxy(new WebUserService());
	}
}
