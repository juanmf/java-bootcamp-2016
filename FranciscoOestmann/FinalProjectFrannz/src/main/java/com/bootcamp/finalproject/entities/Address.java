package com.bootcamp.finalproject.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Address Class", description = "Class used to store user addresses.")
public class Address {

	
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

	
	//Constructor
	public Address(){
		
	}
	public Address(String street, int number, String city, String country, String addressType) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
		this.addressType = addressType;
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
	
	
	
}
