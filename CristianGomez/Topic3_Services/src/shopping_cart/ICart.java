package shopping_cart;

import java.util.List;

/**@author Cadrian
 * Implements a shopping cart for e-commerce usage.
 */
public interface ICart {

    /**
     * Add an item to the cart.
     */
    public void addItem(Item i);

    /**
     * Remove item i from the cart.
     * @param i
     */
    public void removeItem(Item i);

    /**
     * Get all the items to buy at the moment.
     * @return A list of all items on the cart.
     */
    public List<Item> getItems();   

    /**
     * How much for the cart?
     * @return Total amount of money to pay for the cart. A sum of all the items in the cart. 
     */
    public double getTotal();

}
