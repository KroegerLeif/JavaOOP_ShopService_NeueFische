package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeNewOrder(Product product) {
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        placeNewOrder(productList);
    }

    public void placeNewOrder(ArrayList<Product> product) {
        UUID uuid = UUID.randomUUID();
        HashMap<Product,Integer> orderItems = new HashMap<>();
        for(Product p : product){
            if(checksStock(p)){
                addProductToOrder(p,orderItems);
            }else {
                System.out.println("Produkt " + p + " nicht in Stock");
                return;
            }
        }
        BigDecimal sum = calculateTotalValue(orderItems);
        Order order = new Order(uuid.toString(),orderItems, sum);
        orderRepo.addOrder(order);
    }

    public void removeOrder(String ordernummer){
        orderRepo.removeOrder(orderRepo.getOrder(ordernummer));
    }

    public Order getOrder(String ordernummer){
        return orderRepo.getOrder(ordernummer);
    }

    public ArrayList<Order> getAllOrders(){
        return orderRepo.getOrders();
    }

    public void changeOrderAmount(String ordernummer, Product product, int newAmount){
        Order order = orderRepo.getOrder(ordernummer);
        if(order.products().containsKey(product)){
            order.products().put(product,newAmount);
            ArrayList<Product> productList = convertMapToArrayList(order.products());
            //Removes order from repo
            orderRepo.removeOrder(order);
            //Creates a new order with the new amount
            placeNewOrder(productList);
        }else {
            System.out.println("Produkt nicht in Bestellung");
        }
    }

    private boolean checksStock(Product product) {
        //Could also check for amount in stock
        return productRepo.containsProduct(product);
    }

    private HashMap<Product,Integer> addProductToOrder(Product product,HashMap<Product,Integer> orderItems){
        if(orderItems.containsKey(product)){
            int amount = orderItems.get(product);
            amount++;
            orderItems.put(product,amount);
            return orderItems;
        }else {
            orderItems.put(product,1);
            return orderItems;
        }
    }

    private BigDecimal calculateTotalValue(HashMap<Product,Integer> orderItems){
        BigDecimal sum = new BigDecimal("0");
        for (Product p : orderItems.keySet()){
            int amount = orderItems.get(p);
            sum = p.price().multiply(new BigDecimal(amount));
        }
        return sum;
    }

    private ArrayList<Product> convertMapToArrayList(HashMap<Product,Integer> orderItems){
        ArrayList<Product> productList = new ArrayList<>();
        for (Product p : orderItems.keySet()){
            int amount = orderItems.get(p);
            for (int i = 0; i < amount; i++){
                productList.add(p);
            }
        }
        return productList;
    }


    //Boilerplate Code
    //Getter
    public ProductRepo getProductRepo() {
        return productRepo;
    }
    public OrderRepo getOrderListRepo() {
        return orderRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ShopService that)) return false;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderListRepo=" + orderRepo +
                '}';
    }
}
