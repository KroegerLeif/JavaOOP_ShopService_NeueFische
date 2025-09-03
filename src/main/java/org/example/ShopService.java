package org.example;

import java.util.Objects;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo;
    private OrderListRepo orderListRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public void placeNewOrder(Product product) {
        if(checksStock(product)){
            UUID uuid = UUID.randomUUID();
            Order order = new Order(uuid.toString(),product.price());
            orderListRepo.addOrder(order);
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
    public OrderListRepo getOrderListRepo() {
        return orderListRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ShopService that)) return false;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderListRepo, that.orderListRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderListRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderListRepo=" + orderListRepo +
                '}';
    }
}
