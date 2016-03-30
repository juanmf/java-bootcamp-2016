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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info Order", description = "Complete data of a Order Info")

@Entity
@Table(name = "cart_product")
public class Order {
	@ApiModelProperty(value = "the id of the order", required = false)
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
		
	@ApiModelProperty(value = "the product of the order", required = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idproduct")
	private Product product;
	
	@ApiModelProperty(value = "the quantity of the order", required = false)
	@Column(name="quantity")
	private Integer quantity;
	
	/*@ApiModelProperty(value = "the subtotal of the order", required = false)
	@Column(name="subtotal")
	private Double subtotal;*/
	
	@ApiModelProperty(value = "the cart of the order", required = false)
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="idcart")
	@JsonBackReference
	private Cart cart;
	


	public Order() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/*public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}*/
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/*public Double getSubtotal() {
		return subtotal;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Order && id.equals(((Order) obj).getId());
	}
	

}
