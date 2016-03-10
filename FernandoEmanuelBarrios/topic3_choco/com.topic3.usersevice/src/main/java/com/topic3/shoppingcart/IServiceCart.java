package com.topic3.shoppingcart;

import java.util.List;

public interface IServiceCart {
    public void addOrder(Order o);
    public void removeOrder(Order o);
    public List<Order> getOrders();
    public double getTotal();
}

