package com.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.Cart;
import com.finalProject.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	public Cart findByUser(User user);
	public Cart findById(Integer cartId);
}
