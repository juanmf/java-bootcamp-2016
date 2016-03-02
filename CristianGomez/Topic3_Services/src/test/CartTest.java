package test;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import shopping_cart.*;


public class CartTest {
/**@author Cadrian
 * Test cases for Cart class.
 */

    private Cart cart;
    private Item ItemA;
    private Item ItemB;
    private Product productA;
    private Product productB;

    /**
     * Set up the testing context.
     */
    @Before
    public void setUp() {
        cart = new Cart();
        productA = new Product("Cheese", 3.5);
        productB = new Product("Bread", 2.5);
        ItemA = new Item(productA,10);
        ItemB =  new Item(productB,10);
        Assert.assertEquals(ItemA.getProduct(), productA);
        Assert.assertEquals(ItemB.getProduct(), productB);
            
        
    }

    /**
     * When addItem() Then item is in cart.<br>
     * When addItem() Then item has no duplicated item <br>
     */
    @Test
    public void testAddItem() {
        cart.addItem(ItemA);

        List<Item> items = cart.getItems();
        for (Item item : items)
            if (item.getProduct().getName().equals(ItemA.getProduct().getName()))
                Assert.assertEquals(ItemA, item);

        cart.addItem(ItemA);
        cart.removeItem(ItemA);
        for (Item item : items)
            Assert.assertNotEquals(ItemA, item);
    }

    /**
     * When removeItem() Then item is not in cart anymore.
     */
    @Test
    public void testRemoveItem() {
        cart.addItem(ItemA);
        cart.removeItem(ItemA);
        List<Item> items = cart.getItems();
        for (Item item : items)
            Assert.assertNotEquals(ItemA, item);
    }

    /**
     * When getItems() Then return all items present in cart.
     */
    @Test
    public void testGetItems() {
        cart.addItem(ItemA);
        cart.addItem(ItemB);
        
        Assert.assertTrue(cart.getItems().contains(ItemA));
        Assert.assertTrue(cart.getItems().contains(ItemB));
        
        cart.removeItem(ItemA);
        cart.removeItem(ItemB);
        
        Assert.assertTrue(cart.getItems().size() == 0);     
    }

    /**
     * When getTotal() Then return the sum of all item subtotal.
     */
    @Test
    public void testGetTotal() {
     
        cart.addItem(ItemA);
        cart.addItem(ItemB);
        Assert.assertEquals(60.0, cart.getTotal(), 0.00001);
    }

}



