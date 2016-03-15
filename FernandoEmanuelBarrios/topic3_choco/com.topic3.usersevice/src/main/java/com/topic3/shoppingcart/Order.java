package com.topic3.shoppingcart;

/**
 * @author cota
 *
 */
public class Order {
    private Product product;
    private int quantity;

    /**
     * @param product
     * @param quantity
     */
    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Constructor without quantity gives for default quantity 1
     * @param product
     */
    public Order(Product product) {
        this.product = product;
        this.quantity = 1;
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
     * @return an double with the subtotal of the purchase
     */
    public double getSubTotal(){
        return product.getPrice() * getQuantity();
    }
}