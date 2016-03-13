package com.bootcamp.Topic6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.Topic6.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
