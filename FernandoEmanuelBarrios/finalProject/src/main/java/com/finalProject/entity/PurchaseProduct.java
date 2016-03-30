package com.finalProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info PurchaseProduct", description = "Complete data of a PurchaseProduct Info")

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {
	@ApiModelProperty(value = "The id of the purchaseproduct", required = false)

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@ApiModelProperty(value = "The quantity of the purchaseproduct", required = false)
	@Column(name="quantity")
	private Integer quantity;
	
	@ApiModelProperty(value = "The price of the purchaseproduct", required = false)
	@Column(name="price")
	private Double price;
	
	@ApiModelProperty(value = "The product that pertenence to purchaseproduct", required = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idproduct")
	private Product product;
	
	@ApiModelProperty(value = "The purchase that pertenence to purchaseproduct", required = false)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idpurchase")
	private Purchase purchase;
	

	public PurchaseProduct() {
		
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

	public Purchase getPurchase() {
		return purchase;
	}


	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	
	

}
