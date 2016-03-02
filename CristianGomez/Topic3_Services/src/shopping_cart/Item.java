package shopping_cart;
/**@author Cadrian
 * Represents an item in the cart. It has a product and the quantity of
 * instances of that product.
 * @since 1.0
 */
public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the price to pay for this item.
     * @return Products price by quantity.
     */
    public double getSubtotal() {
        return getProduct().getPrice() * getQuantity();
    }

}
