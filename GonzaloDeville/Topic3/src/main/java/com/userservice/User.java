package com.userservice;


/**
 * @author cota
 *
 */
public class User {
	private static int countId = 1;
	private int id;
	private String userName;
	private String psw;

	public User(String nickName, String psw) {
		this.userName = nickName;
		this.psw = psw;
		id = countId;
		countId++;
	}

	public static int getCountId() {
		return countId;
	}

	public static void setCountId(int countId) {
		User.countId = countId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String usrName) {
		this.userName = usrName;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((psw == null) ? 0 : psw.hashCode());
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
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (psw == null) {
			if (other.psw != null)
				return false;
		} else if (!psw.equals(other.psw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User Name=" + userName + ", Password=" + psw + " ";
	}

}