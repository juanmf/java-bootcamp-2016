package java.Cart;

import java.user.User;
import java.util.LinkedList;

public class Cart {
    private User user;
    private LinkedList<CartItem> items;
    private double total;
    
    public Cart(User user) {
        this.user = user;
        items = new LinkedList<CartItem>();
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LinkedList<CartItem> getItems() {
        return items;
    }
    public void setItems(LinkedList<CartItem> items) {
        this.items = items;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    

}