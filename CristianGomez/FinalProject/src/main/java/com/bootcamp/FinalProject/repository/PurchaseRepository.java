package com.bootcamp.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.FinalProject.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
