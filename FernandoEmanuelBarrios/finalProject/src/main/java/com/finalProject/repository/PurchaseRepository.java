package com.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.entity.Purchase;



public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
	public Purchase findById (Integer id);
	
}