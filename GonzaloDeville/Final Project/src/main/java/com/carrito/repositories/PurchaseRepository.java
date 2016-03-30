package com.carrito.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.Purchase;
import com.carrito.entities.User;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
	
	public Purchase findById (Integer id);
	public User findByUser (User user);
	
	
}
