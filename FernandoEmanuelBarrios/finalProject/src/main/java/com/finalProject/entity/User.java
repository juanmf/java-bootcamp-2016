package com.finalProject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Info User", description = "Complete data of a User Info")

@Entity
@Table(name = "user")
public class User {
	@ApiModelProperty(value = "The id of the user", required = false)
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@ApiModelProperty(value = "The firstname of the user", required = false)
	@Column(name = "firstname")
	private String firstName;

	@ApiModelProperty(value = "The lastname of the user", required = false)
	@Column(name = "lastname")
	private String lastName;

	@ApiModelProperty(value = "The username of the user", required = false)
	@Column(name = "username")
	private String userName;
	
	@ApiModelProperty(value = "The mail of the user", required = false)
	@Column(name = "mail")
	private String mail;

	@ApiModelProperty(value = "The password of the user", required = false)
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@ApiModelProperty(value = "list of purchases of the user", required = false)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "idpurchase")
	@JsonIgnore
	List<Purchase> purchases;
	
	/*@ApiModelProperty(value = "cart that corresponds to the user", required = false)
	@OneToOne(mappedBy = "user")
	//@JsonIgnore
	private Cart cart;*/

	public User() {

	}
	

	public User(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}


	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	/*public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}*/

	@JsonProperty(required = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	@JsonProperty(required = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty(required = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setAddres(String addres) {
		this.mail = addres;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof User && userName.equalsIgnoreCase(((User) obj).getUserName())
				&& mail.equalsIgnoreCase(((User) obj).getMail());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

}
