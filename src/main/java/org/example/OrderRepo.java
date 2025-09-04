package org.example;

import java.util.ArrayList;

public interface OrderRepo {
    void addOrder(Order order);
    void removeOrder(Order order);
    Order getOrder(int index);
    ArrayList<Order> getOrders();
}
