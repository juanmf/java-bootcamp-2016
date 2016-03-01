package java.Cart;

import java.inventory.Product;
import java.user.User;

/**
 * Interface that defines what a Cart must do.
 * @author Adrian Gomez 
 *
 */

public interface CartService {
    
    public void createCart(User u);
    
    public Cart findCart(User u);

    public void addProductToCart(Cart c, Product p, int quantity);

    public void updateQuantity(Cart c, Product p, int quantity);

    public void removeProductFromCart(Cart c, Product p);

    public double checkout(User u);

    public boolean isProductInCart(Cart cart, Product p);
}