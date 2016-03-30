package com.finalProject.entity;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info Cart", description = "Complete data of a Cart Info")
@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the Cart")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "iduser")
	@ApiModelProperty(value = "The User of the Cart")
	private User user;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	
	@Column(name = "idcartproduct")
	@ApiModelProperty(value = "List of products no yet purchased")
	@JsonManagedReference
	private List<Order> orders;
	
	@Column(name = "total")
	@ApiModelProperty(value = "The total of the Cart")
	private double total;
	

	public Cart() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Order> getOrder() {
		return orders;
	}

	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}
	
	public Double getTotal() {
		return total;
		
	}

	public void setTotal(Double total) {
		this.total = total;
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
		return obj != null && obj instanceof Cart && id.equals(((Cart) obj).getId());
	}


}