package test;

import static org.junit.Assert.*;

import java.Cart.Cart;
import java.Cart.CartService;
import java.Cart.CartServiceImpl;
import java.inventory.InventoryService;
import java.inventory.InventoryServiceImpl;
import java.inventory.Product;
import java.user.User;
import java.user.UsersService;
import java.user.UsersServiceImpl;

import org.junit.Test;

public class TestCartService {
    
    @Test
    public void createCartTest() {
        
        CartService cartService = new CartServiceImpl();
        InventoryService inventory = new InventoryServiceImpl();
        UsersService userService = new UsersServiceImpl();
        
        inventory.createProduct(new Product(1, "Hard Disk", null, "A hard disk", 20));
        userService.createUser(new User("edwarx", "password"));
        cartService.createCart(userService.findUser(new User("edwarx")));
        assertNotNull(cartService.findCart(new User("edwarx")));
    }
    @Test
    public void addItemToCartTest() {
        CartService cartService = new CartServiceImpl();
        InventoryService inventory = new InventoryServiceImpl();
        UsersService userService = new UsersServiceImpl();
        
        inventory.createProduct(new Product(1, "Hard Disk", null, "A hard disk", 20));
        userService.createUser(new User("edwarx", "password"));
        cartService.createCart(userService.findUser(new User("edwarx")));
        Cart cart = cartService.findCart(userService.findUser(new User("edwarx")));
        
        cartService.addProductToCart(cart, new Product(1), 5);
        assertTrue(cartService.isProductInCart(cart,new Product(1)));
        cartService.removeProductFromCart(cart, new Product(1));
    }
    @Test
    public void checkoutTest() {
        CartService cartService = new CartServiceImpl();
        InventoryService inventory = new InventoryServiceImpl();
        UsersService userService = new UsersServiceImpl();
        
        inventory.createProduct(new Product(1, "Hard Disk", null, "A hard disk", 20));
        inventory.createProduct(new Product(2, "Cooler", null, "A cooler", 10));
        User u=new User("edwarx", "password");
        userService.createUser(u);
        cartService.createCart(userService.findUser(new User("edwarx")));
        Cart cart = cartService.findCart(userService.findUser(new User("edwarx")));
        cartService.addProductToCart(cart, inventory.findProduct(new Product(1)), 5);
        cartService.addProductToCart(cart, inventory.findProduct(new Product(2)), 2);
        assertEquals(120, cartService.checkout(new User("edwarx")), 0);
    }

}