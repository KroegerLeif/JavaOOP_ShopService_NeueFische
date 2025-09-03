package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class OrderListRepo {
    private ArrayList<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public Order getOrder(int index) {
        return orders.get(index);
    }

    //Boilerplate Code
    //Getter
    public ArrayList<Order> getOrders() {
        return orders;
    }

    //Equals und HashCode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderListRepo that)) return false;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    //ToString
    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
