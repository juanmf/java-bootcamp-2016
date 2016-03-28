package com.bootcamp.finalproject.entities;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
	
	@ApiModelProperty(value="User DNI.")
	private int dni;
	
	/*@ApiModelProperty(value="User Addresses List.")
	private List<Address> addresses;*/
	
	
	//Constructor
	public User(){
		
	}
	public User(String firstName, String lastName, String userName, int dni) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
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
	/*
	public List<Address> getAllAddresses() {
		return addresses;
	}
	
	public Address getSingleAddress(String id){
		Address temp = null;
		for(int i = 0; i<addresses.size(); i++){
			if(addresses.get(i).getId().equals(id)){
				temp = addresses.get(i);
			}
		}
		
		return temp;
	}

	public void setAddress(Address address) {
		addresses.add(address);
	}
	*/
	
	//Behavior
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}

	
	public boolean equals(User obj) {
		if (this.dni == obj.getDni()) {
			return true;
		}
		return false;
	}
	
	
	
}
