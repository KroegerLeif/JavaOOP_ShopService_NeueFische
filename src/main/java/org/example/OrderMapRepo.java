package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderMapRepo implements OrderRepo {

    private HashMap<String, Order> orders;

    //constructor
    public OrderMapRepo() {}

    //interface implementation
    @Override
    public void addOrder(Order order) {
        String key = order.orderNumber();
        orders.put(key,order);
    }

    @Override
    public void removeOrder(Order order) {
        String key = order.orderNumber();
        orders.remove(key);
    }

    @Override
    public Order getOrder(String kontonummmer) {
        if (orders.containsKey(kontonummmer)){
            return orders.get(kontonummmer);
        }else{
            System.out.println("Keine Bestellung gefunden");
            return null;
        }
    }

    @Override
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orderList = new ArrayList<>();
        for (Order order: orders.values()){
            orderList.add(order);
        }
        return orderList;
    }

}
