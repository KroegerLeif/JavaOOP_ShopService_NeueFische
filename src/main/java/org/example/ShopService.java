package org.example;

import java.util.Objects;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeNewOrder(Product product) {
        if(checksStock(product)){
            UUID uuid = UUID.randomUUID();
            Order order = new Order(uuid.toString(),product.price());
            orderRepo.addOrder(order);
        }else {
            System.out.println("Produkt nicht in Stock");
        }
    }

    private boolean checksStock(Product product) {
        //Could also check for amount in stock
        return productRepo.containsProduct(product);
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
