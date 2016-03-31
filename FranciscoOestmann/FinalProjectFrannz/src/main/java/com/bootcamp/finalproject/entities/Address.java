package com.bootcamp.finalproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel(value = "Address Class", description = "Class used to store user addresses.")
public class Address {

	@ApiModelProperty(value="User Id")
	@Id
	String id;
	
	@ApiModelProperty(value="User Addresses.")
	User user;
	
	@ApiModelProperty(value="Address Type.")
	private String addressType;
	
	@ApiModelProperty(value="Street.")
	private String street;
	
	@ApiModelProperty(value="Number.")
	private int number;
	
	@ApiModelProperty(value="City.")
	private String city;
	
	@ApiModelProperty(value="Country.")
	private String country;
	
	@ApiModelProperty(value="Postal Code.")
	private int postalCode;

	
	//Constructor
	public Address(){
		
	}
	public Address(User user, String addressType, String street, int number, String city, String country, int postalCode) {
		this.user = user;
		this.addressType = addressType;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		
	}

	//Getters & Setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAddressType() {
		return addressType;
	}
	
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
}
