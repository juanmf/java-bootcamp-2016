package com.finalProject.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info Purchase", description = "Complete data of a Purchase Info")


@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the Purchase")
	private Integer id;

	/*@ManyToOne
	@JoinColumn(name = "iduser")
	@JsonIgnore*/
	@OneToOne
	@JoinColumn(name = "iduser")
	@ApiModelProperty(value = "The user of the Purchase")
	private User user;

	@ApiModelProperty(value = "List of products no yet purchased")
	@OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
	private List<PurchaseProduct> purchaseProducts;

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

	public List<PurchaseProduct> getPurchaseProducts() {
		return purchaseProducts;
	}

	public void setPurchasedProducts(List<PurchaseProduct> purchasedProducts) {
		this.purchaseProducts = purchasedProducts;
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

		purchaseProducts = new LinkedList<PurchaseProduct>();

		Iterator<Order> it = cart.getOrder().iterator();

		while (it.hasNext()) {
			Order order = it.next();
			PurchaseProduct purchaseProducts = new PurchaseProduct();
			purchaseProducts.setProduct(order.getProduct());
			purchaseProducts.setQuantity(order.getQuantity());
			purchaseProducts.setPurchase(this);
			getPurchaseProducts().add(purchaseProducts);
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
