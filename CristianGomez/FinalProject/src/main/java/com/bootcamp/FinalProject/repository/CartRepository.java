package com.bootcamp.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.FinalProject.entity.Cart;
import com.bootcamp.FinalProject.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Cart findByUser(User user);
}
