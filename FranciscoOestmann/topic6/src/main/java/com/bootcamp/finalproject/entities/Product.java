package com.bootcamp.finalproject.entities;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Product Class.", description = "Class used to create a Product Object to be added to the Shopping Cart.")
public class Product {

	@ApiModelProperty(value="Product Id.")
	@Id
	private  String id;
	
	@ApiModelProperty(value="Product name.")
	private String productName;
	
	@ApiModelProperty(value="Product category.")
	private String productCategory;
	
	@ApiModelProperty(value="Product price.")
	private double productPrice;
	
	@ApiModelProperty(value="Product quantity..")
	private int productQuantity = 0;
	
	//Constructors
	public Product(){
		
	}
	public Product(String productName, String productCategory, int productQuantity, double productPrice) {
	
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;

	}

	
	//Getters & Setters
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return productCategory;
	}
	
	public void setCategory(String category) {
		this.productCategory = category;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int quantity) {
		this.productQuantity = quantity;
	}
	//Behavior
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime + result + productQuantity;
		return result;
	}
	
	
	public boolean equals(Product obj) {
		if (this.id.equals(obj.getId())) {
			return true;
		}
		return false;
	}
	
	
}
