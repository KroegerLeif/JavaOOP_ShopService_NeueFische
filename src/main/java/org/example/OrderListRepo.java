package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {
    private ArrayList<Order> orders;

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getOrder(String kontonummmer){
        for(Order order : orders){
            if(order.orderNumber().equals(kontonummmer)){
                return order;
            }
        }
        System.out.println("Kein Bestellung gefunden");
        return null;
    }

    //Methoden
    public Order getOrder(int index) {
        return orders.get(index);
    }

    //Boilerplate Code
    //Getter
    @Override
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
