package shopping_cart;

import java.util.ArrayList;
import java.util.List;

/**@author Cadrian
 * A concrete implementation of the Cart API. 
 */
public class Cart implements ICart {

    private List<Item> items;

    /**
     * The simplest constructor.
     */
    public Cart() {
        this.items = new ArrayList<Item>();
    }
    
    /**
     * Add an item to the cart.
     */
    public void addItem(Item i) {
        if (!items.contains(i))
            items.add(i);
    }

    /**
     * Remove item i from the cart.
     * @param i
     */
    public void removeItem(Item i) {
        this.items.remove(i);
    }

    /**
     * Get all the items to buy at the moment.
     * @return a list of all items on the cart.
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * How much for the cart?
     * @return Total amount of money to pay for the cart. A sum of all the items in the cart. 
     */
    public double getTotal() {
        double subtotal = 0;
        for (Item item : getItems())
            subtotal = subtotal + item.getSubtotal();
        return subtotal;
    }

}
