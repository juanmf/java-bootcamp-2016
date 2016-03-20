package user;


import java.util.concurrent.atomic.AtomicInteger;

import cart.ShoppingCart;


public class User {

	
	private static AtomicInteger ID = new AtomicInteger(1000);
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private int dni;
	
	
	
	private ShoppingCart shoppingCart;
	
	
	//Constructor
	public User(String firstName, String lastName, String userName, int dni) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.dni = dni;
		ID.getAndIncrement();
		
	}

	//Getters & Setters
	public AtomicInteger getId() {
		return ID;
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
	
	
	public ShoppingCart getShoopingCart() {
		return shoppingCart;
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
		if (this.ID == obj.ID) {
			return true;
		}
		if(this.userName.equals(obj.userName)){
			return true;
		}
		return false;
	}
	
	
	
}
