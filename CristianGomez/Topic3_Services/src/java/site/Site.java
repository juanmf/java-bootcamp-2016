package java.site;

import java.Cart.Cart;
import java.inventory.Category;
import java.inventory.Product;
import java.user.User;
import java.util.LinkedList;

/**
 * Class that simulates a database where all the data from the Shopping Cart is stored.
 * @author Adrian Gomez
 * @version 1.0
 * @since 1.0
 */
public class Site {
    private LinkedList<Product> products;
    private LinkedList<Category> categories;
    private LinkedList<User> users;
    private LinkedList<Cart> carts;
    private static Site instance;

    private Site() {
        products = new LinkedList<Product>();
        categories = new LinkedList<Category>();
        users = new LinkedList<User>();
        setCarts(new LinkedList<Cart>());
    }

    public static Site getInstance() {
        if (instance == null) {
            instance = new Site();
        }
        return instance;
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }

    public LinkedList<Category> getCategories() {
        return categories;
    }

    public void setCategories(LinkedList<Category> categories) {
        this.categories = categories;
    }

    public LinkedList<Cart> getCarts() {
        return carts;
    }

    public void setCarts(LinkedList<Cart> carts) {
        this.carts = carts;
    }

}