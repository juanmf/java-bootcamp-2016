package com.carrito.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
@ApiModel(value = "User entity", description = "Complete data of a entity User")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "The id of the User")
	private Integer id;

	@Column(name = "firstname")
	@ApiModelProperty(value = "The first name of the User")
	private String firstName;

	@Column(name = "lastname")
	@ApiModelProperty(value = "The last name of the User")
	private String lastName;

	@Column(name = "username")
	@ApiModelProperty(value = "The username of the User")
	private String userName;

	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	@ApiModelProperty(value = "The password of the User")
	private String password;

	@Column(name = "mail")
	@ApiModelProperty(value = "The mail of the User")
	private String mail;

	public User() {
	}

	public User(String username, String password) {
		this.userName = username;
		this.password = password;
	}
		
	@JsonProperty(required = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof User && userName.equalsIgnoreCase(((User) obj).getUserName())
				&& mail.equalsIgnoreCase(((User) obj).getMail());
	}

}
