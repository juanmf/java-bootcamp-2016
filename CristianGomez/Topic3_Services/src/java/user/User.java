package java.user;

import java.util.LinkedList;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LinkedList<Address> addresses;
    private boolean isLoggedIn;

    public User(String firstName, String lastName, String username, String password, Address address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.addresses = new LinkedList<Address>();
        addresses.add(address);
        this.isLoggedIn = false;
    }

    public User(String firstName, String lastName, String username, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isLoggedIn = false;
    }
    public User(String username) {
        this.username = username;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedList<Address> getAddress() {
        return addresses;
    }

    public void setAddress(LinkedList<Address> address) {
        this.addresses = address;
    }

    public boolean equals(User u) {
        if (this.username.compareTo(u.getUsername()) == 0) {
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}