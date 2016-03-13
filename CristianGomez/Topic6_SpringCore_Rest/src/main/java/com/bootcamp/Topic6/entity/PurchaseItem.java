package com.bootcamp.Topic6.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "purchase_item")
public class PurchaseItem {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product")
	private Product product;
	private int quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "purchase")
	@JsonBackReference
	private Purchase purchase;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public int getId() {
		return id;
	}

}
