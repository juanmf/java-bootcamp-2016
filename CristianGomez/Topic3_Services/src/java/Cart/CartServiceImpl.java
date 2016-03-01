package java.Cart;

import java.inventory.InventoryService;
import java.inventory.InventoryServiceImpl;
import java.inventory.Product;
import java.site.Site;
import java.user.User;
import java.user.UsersService;
import java.user.UsersServiceImpl;
import java.util.Iterator;

/**
 * Implementation of the CartService Interface.
 * @author Adrian Gomez
 *
 */

public class CartServiceImpl implements CartService {
    /**
     * Class variable that retrieves the instance of the Site (database mock).
     */
    Site s;
    
    /**
     * Class constructor
     */
    public CartServiceImpl() {
        s = Site.getInstance();
    }

    /**
     * Creates a Cart for a User that is found in the Database, in case the User can't be found,
     * it creates the User and then the Cart.
     * Also adds the Cart to the database.
     * @param The User to be added to the database.
     */
    public void createCart(User u) {
        UsersService userService = new UsersServiceImpl();
        if(userService.findUser(u) == null) {
            userService.createUser(u);
        }
        s.getCarts().add(new Cart(u));
        
    }
    /**
     * Method that finishes a purchase from a User.
     * @return The total amount of the User's Cart.
     * @param The User that will checkout his Cart.
     */
    public double checkout(User u) {
        Cart c = findCart(u);
        double orderTotal = 0;
        Iterator<CartItem> it = c.getItems().iterator();
        while(it.hasNext()) {
            CartItem aux = it.next();
            orderTotal = orderTotal + (aux.getProduct().getPrice()*aux.getQuantity());
        }
        c.setTotal(orderTotal);
        return c.getTotal();    
    }

    /**
     * Method to find the Cart for a User, in case the user can't be found in the database, it returns null.
     * @param The User that owns a Cart.
     * @return The Cart of the user.
     */
    public Cart findCart(User u) {
        Iterator<Cart> it = s.getCarts().iterator();
        while (it.hasNext()) {
            Cart aux=it.next();
            if(aux.getUser().equals(u)) {
                return aux;
            }
        }
        return null;
    }
/**
 * Adds a product and the quantity to be purchased to the Cart.
 * The product is searched in the database, in case it doesn't exists, this method creates it.
 * @param The Product that will be added to a Cart.
 * @param The quantity of that Product.
 * @param The Cart where the CartItem will be created.
 */
    public void addProductToCart(Cart c, Product p, int quantity) {
        InventoryService inventory = new InventoryServiceImpl();
        Product inventoryProduct = inventory.findProduct(p); 
        if(inventoryProduct == null) {
            inventory.createProduct(p);
            inventoryProduct = inventory.findProduct(p);
        }
        CartItem item = new CartItem(inventoryProduct, quantity);
        c.getItems().add(item);
        
    }
/**
 * Update the quantity to be purchased of a Product already in the Cart.
 * @param The Product that will be updated in the Cart.
 * @param The new quantity of that Product.
 * @param The Cart object where the CartItem will be updated.
 */
    public void updateQuantity(Cart c, Product p, int quantity) {
        // TODO Auto-generated method stub
    }
/**
 * Removes a Product from a Cart already in the database.
 *@param The Product that will be removed from the Cart.
 *@param The Cart that will be updated.
 */
    public void removeProductFromCart(Cart c, Product p) {
        InventoryService inventory = new InventoryServiceImpl();
        Product inventoryProduct = inventory.findProduct(p); 
        if(inventoryProduct == null) {
            inventory.createProduct(p);
            inventoryProduct = inventory.findProduct(p);
        }
        Iterator<CartItem> it = c.getItems().iterator();
        while(it.hasNext()) {
            CartItem aux = it.next();
            if(aux.getProduct().equals(inventoryProduct)) {
                c.getItems().remove(aux);
            }
        }
    }
/**
 * Checks if a given Product is in a Cart.
 * @return True if the Product is in the Cart, false is the Product is not in the Cart.
 * @param The Cart where the Product is expected to be found.
 * @param The Product to be found.
 */
    public boolean isProductInCart(Cart cart, Product p) {
        InventoryService inventory = new InventoryServiceImpl();
        Product inventoryProduct = inventory.findProduct(p); 
        if(inventoryProduct == null) {
            inventory.createProduct(p);
            inventoryProduct = inventory.findProduct(p);
        }
        Iterator<CartItem> it = cart.getItems().iterator();
        while (it.hasNext()) {
            if(it.next().getProduct().equals(inventoryProduct)) {
                return true;
            }
        }
        return false;
    }
    
}