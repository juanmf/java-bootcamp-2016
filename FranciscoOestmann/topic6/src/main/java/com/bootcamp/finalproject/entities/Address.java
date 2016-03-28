package com.bootcamp.finalproject.entities;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Address Class", description = "Class used to store user addresses.")
public class Address {

	@ApiModelProperty(value="Address Id.")
	@Id
	private String id;
	
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
	public Address(String street, int number, String city, String country) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	//Getters & Setters
	public String getId() {
		return id;
	}

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
	
	
	
}
