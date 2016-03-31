package com.bootcamp.finalproject.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document
@Component
@ApiModel(value = "User Class", description = "Class use to create an User Object to use the API")
public class User {

	@ApiModelProperty(value="User Id")
	@Id
	private String id;
	
	@ApiModelProperty(value="User First Name.")
	private String firstName;
	
	@ApiModelProperty(value="User Last Name.")
	private String lastName;
	
	@ApiModelProperty(value="User alias.")
	private String userName;
	
	@ApiModelProperty(value="User Password.")
	private String password;
	
	@ApiModelProperty(value="User Email.")
	private String eMail;
	
	@ApiModelProperty(value="User DNI.")
	private int dni;
	
	@ApiModelProperty(value="User Log Status")
	private boolean connected = false;
	
	
	
	
	//Constructor
	public User(){
		
	}
	
	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String userName, String password, String eMail, int dni) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.eMail = eMail;
		this.dni = dni;
		
	}

	
	
	//Getters & Setters
	public String getId() {
		return id;
	}
	
	public void setId(String id){
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	
	
	
	
	//Behavior
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	
	
	
}
