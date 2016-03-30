package com.carrito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.Cart;
import com.carrito.entities.User;

public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	public Cart findByUser(User user);
	
	public Cart findById(Integer id);

}
