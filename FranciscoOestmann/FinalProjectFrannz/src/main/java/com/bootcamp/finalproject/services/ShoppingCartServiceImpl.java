package com.bootcamp.finalproject.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.finalproject.entities.Product;
import com.bootcamp.finalproject.repositories.ShoppingCartRepository;


@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	//State
	@Autowired
	ShoppingCartRepository cartRepo;
	
	List<Product> list = null;
	
	
	//Constructor
	public ShoppingCartServiceImpl() {
	
		list = new LinkedList<Product>();
	}
	
	
	//Behavior
	/**
	 * The Method takes a Product and adds it to the ShopingCart list.
	 * If productQantity needs to be increase, use updateCart method.
	 * 
	 */
	@Override
	public void addItemToCart(Product product) {
		list.add(product);
		
	}
	
	
	
	/**
	 * This Method takes a Product and removes it from the ShopingCart list.
	 * If productQantity needs to be decrease, use updateCart method.
	 * 
	 */
	@Override
	public  void removeItemFromCart(Product product) {
		list.remove(product);
		/*
		if(!list.isEmpty()){
			for(int i = 0; i<list.size(); i++){
				if(list.get(i).getId().equals(product.getId())){
					list.remove(list.get(i));
				}
			}
		}*/
	}
	
	
	
	/**
	 * Updates cart's Product quantity. It takes a Product, finds it in the cartList and modifies it's quantity.
	 * product an modify it's quantity.
	 */
	@Override
	public void updateCart(Product product) {

		for(Product prod: list){
			if(prod.getProductName().equals(product.getProductName())){
				prod.setProductQuantity(product.getProductQuantity());
			}
		}
	}

	
	
	/**
	 * This Method Calculates the total cost of all the Items in the Shopping Cart.
	 * 
	 */
	@Override
	public double calculateTotalPurchase() {
		double totalCost = 0;
		for(int i = 0; i<list.size(); i++){
			totalCost = totalCost + (list.get(i).getProductPrice() * list.get(i).getProductQuantity());
		}
		return totalCost;
	}
	
	
	
	/**
	 * This Method returns the list of Items in Shopping Cart.
	 * 
	 */
	@Override
	public List<Product> getCartList() {
		return list;
	}

	
	
	/**
	 * Clears cart from every Product.
	 * 
	 */
	@Override
	public void clearCart() {
		list.clear();
	}

	

}
