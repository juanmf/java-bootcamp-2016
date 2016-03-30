package com.carrito.services;

import com.carrito.entities.User;

public interface LogUserService {

	public boolean login(User user);

	public boolean logout(User user);
	
}
