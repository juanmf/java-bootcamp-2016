package com.carrito.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "purchase_product")
@ApiModel(value = "PurchasedProduct entity", description = "Complete data of a entity PurchasedProduct")
public class PurchasedProduct {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the PurchasedProduct")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproduct")
	@ApiModelProperty(value = "The product of the PurchasedProduct")
	private Product product;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idpurchase")
	@ApiModelProperty(value = "The purchase of the PurchasedProduct")
	@JsonBackReference
	private Purchase purchase;
	
	@Column(name = "quantity")
	@ApiModelProperty(value = "The quantity of the PurchasedProduct")
	private Integer quantity;
	
	public PurchasedProduct() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof PurchasedProduct && id.equals(((PurchasedProduct) obj).getId());

	}

}
