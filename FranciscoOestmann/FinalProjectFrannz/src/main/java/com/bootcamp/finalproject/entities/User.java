package com.bootcamp.finalproject.entities;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
	
	@ApiModelProperty(value="User DNI.")
	private int dni;
	
	@ApiModelProperty(value="User Addresses List.")
	private List<Address> addresses;
	
	
	//Constructor
	public User(){
		
	}
	
	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String userName, String password, int dni) {
		addresses = new LinkedList<Address>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
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
	
	
	public List<Address> getAllAddresses() {
		return addresses;
	}
	
	public Address getSingleAddress(String street, int number){
		Address temp = null;
		for(int i = 0; i<addresses.size(); i++){
			if(addresses.get(i).getStreet().equals(street) && addresses.get(i).getNumber() == number){
				temp = addresses.get(i);
			}
		}
		
		return temp;
	}

	public void setAddress(Address address) {
		addresses.add(address);
	}
	
	
	

	//Behavior
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		return result;
	}

	
	public boolean equals(User obj) {
		if (this.id == obj.getId()) {
			return true;
		}
		return false;
	}
	
	
	
}
