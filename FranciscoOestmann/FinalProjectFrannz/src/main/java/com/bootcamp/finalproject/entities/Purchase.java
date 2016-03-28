package com.bootcamp.finalproject.entities;


import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class Purchase {

	//State
	@ApiModelProperty(value="User Id")
	@Id
	private String id;
	
	@ApiModelProperty(value="ShoppingCart User.")
	private User user;
	
	@ApiModelProperty(value="ShoppingCart Products.")
	private List<Product> products = new LinkedList<Product>();
	
	@ApiModelProperty(value="ShoppingCart Purchase total.")
	private double total;
	
	
	
	//Constructor
	public Purchase(){
		
	}
	
	public Purchase(User user, double total, List<Product> products){
		this.user = user;
		this.total = total;
		this.products = products;
		
	}

	
	//Getters & Setters
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
