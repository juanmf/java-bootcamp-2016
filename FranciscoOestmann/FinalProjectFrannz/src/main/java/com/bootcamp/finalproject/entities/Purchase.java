package com.bootcamp.finalproject.entities;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

public class Purchase {

	//State
	@ApiModelProperty(value="User Id")
	@Id
	private String id;
	
	@ApiModelProperty(value="Purchase Date.")
	private String date;
	
	@ApiModelProperty(value="ShoppingCart User.")
	private User user;
	
	@ApiModelProperty(value="ShoppingCart Products.")
	private List<Product> products = new LinkedList<Product>();
	
	@ApiModelProperty(value="ShoppingCart User's Addresses.")
	private List<Address> addresses = new LinkedList<Address>();
	
	@ApiModelProperty(value="ShoppingCart Purchase total.")
	private double total;
	
	
	
	//Constructor
	public Purchase(){
		
	}
	
	public Purchase(User user, double total, List<Product> products, List<Address> addresses){
		this.user = user;
		this.total = total;
		this.products = products;
		this.addresses = addresses;
		
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		
		this.date = formattedDate;
	}

	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
}
