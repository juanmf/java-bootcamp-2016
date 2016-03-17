package com.bootcamp.FinalProject.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "purchase")
public class Purchase {
    
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PurchaseItem> purchaseItem;
	
	private double total;
	
	private String state;

	public void create(Cart cart) {
		this.setUser(cart.getUser());
		this.setTotal(cart.getTotal());
		this.setState("Created");
		purchaseItem = new LinkedList<PurchaseItem>();
		Iterator<CartItem> it = cart.getCartItem().iterator();
		while (it.hasNext()) {
			CartItem cartItem = it.next();
			PurchaseItem purchaseItem = new PurchaseItem();
			purchaseItem.setProduct(cartItem.getProduct());
			purchaseItem.setQuantity(cartItem.getQuantity());
			purchaseItem.setPurchase(this);
			this.getPurchaseItem().add(purchaseItem);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PurchaseItem> getPurchaseItem() {
		return purchaseItem;
	}

	public void setPurchaseItem(List<PurchaseItem> purchaseItem) {
		this.purchaseItem = purchaseItem;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
