package com.carrito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.entities.Purchase;
import com.carrito.entities.PurchasedProduct;
import com.carrito.entities.User;

public interface PurchaseProductRepository extends JpaRepository<PurchasedProduct,Integer> {

}
