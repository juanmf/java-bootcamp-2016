package com.carrito.entities;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "purchase")
@ApiModel(value = "Purchase entity", description = "Complete data of a entity Purchase")
public class Purchase {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the Purchase")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "iduser")
	@ApiModelProperty(value = "The user of the Purchase")
	private User user;

	@ApiModelProperty(value = "List of products no yet purchased")
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<PurchasedProduct> purchasedProducts;

	@Column(name = "total")
	@ApiModelProperty(value = "The total of the Purchase")
	private Double total;

	public Purchase() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PurchasedProduct> getPurchasedProducts() {
		return purchasedProducts;
	}

	public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
		this.purchasedProducts = purchasedProducts;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void create(Cart cart) {
		this.setUser(cart.getUser());
		this.setTotal(cart.getTotal());
		
		purchasedProducts = Collections.synchronizedList(new LinkedList<PurchasedProduct>());

		Iterator<CartProduct> it = cart.getCartProduct().iterator();

		while (it.hasNext()) {
			CartProduct cartProduct = it.next();
			PurchasedProduct purchasedProducts = new PurchasedProduct();
			purchasedProducts.setProduct(cartProduct.getProduct());
			purchasedProducts.setQuantity(cartProduct.getQuantity());
			purchasedProducts.setPurchase(this);
			getPurchasedProducts().add(purchasedProducts);
		}

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
		return obj != null && obj instanceof Purchase && id.equals(((Purchase) obj).getId());
	}

}
