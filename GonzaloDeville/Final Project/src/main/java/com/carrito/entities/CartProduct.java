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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "cart_product")
@ApiModel(value = "CartProduct entity", description = "Complete data of a entity CartProduct")
public class CartProduct {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the CartProduct")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproduct")
	@ApiModelProperty(value = "The product of the CartProduct")
	private Product product;
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcart")
	@ApiModelProperty(value = "The cart of the CartProduct")
	private Cart cart;
	
	@Column(name = "quantity")
	@ApiModelProperty(value = "The quantity of the CartProduct")
	private Integer quantity;
	
	public CartProduct() {
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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
		return obj != null && obj instanceof CartProduct && id.equals(((CartProduct) obj).getId());
	}
	
	
}
