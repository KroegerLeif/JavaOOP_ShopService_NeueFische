package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Creation of products
        Product product = new Product("Kaffe", new BigDecimal("1.50"));
        Product product2 = new Product("Brot", new BigDecimal("0.50"));
        Product product3 = new Product("Milch", new BigDecimal("0.75"));
        Product product4 = new Product("Bier", new BigDecimal("2.00"));
        Product product5 = new Product("Schokolade", new BigDecimal("0.80"));
        Product product6 = new Product("Tee", new BigDecimal("1.00"));
        Product product7 = new Product("Schokoladen", new BigDecimal("1.20"));
        Product product8 = new Product("Aperol", new BigDecimal("1.00"));

        //Creation of a Product Repro
        ProductRepo repoProduct = new ProductRepo("Shop");
        repoProduct.addProduct(product);
        repoProduct.addProduct(product2);
        repoProduct.addProduct(product3);
        repoProduct.addProduct(product4);
        repoProduct.addProduct(product5);
        repoProduct.addProduct(product6);
        repoProduct.addProduct(product7);
        repoProduct.addProduct(product8);

        //Creation of Order Repos Map & List
        OrderRepo repoMap = new OrderMapRepo();
        OrderRepo repoList = new OrderListRepo();

        //Creation of Shop Service To test both Integration of Order Repros
        ShopService shopService = new ShopService(repoProduct,repoMap);
        ShopService shopService1 = new ShopService(repoProduct,repoList);

        //Creates a List of Products
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        //Initial OrderPlaced in Shop Service
        shopService.placeNewOrder(productList);
        shopService1.placeNewOrder(productList);

        //Shop service
        shopService.placeNewOrder(product6);
        shopService.placeNewOrder(product6);
        shopService.placeNewOrder(product7);
        shopService.placeNewOrder(product8);

        //Shop service 1
        shopService1.placeNewOrder(product6);

        //Prints out what is in the shop service
        System.out.println(shopService);
        System.out.println(shopService1);

        //Prints out all orders in the shop service
        ArrayList<Order> ordersService = shopService.getAllOrders();
        for(Order order : ordersService){
            System.out.println(order);
        }

        //Prints out all orders in the shop service 1
        ArrayList<Order> ordersService1 = shopService1.getAllOrders();
        for(Order order : ordersService1){
            System.out.println(order);
        }

        //Removes the first order in the shop service
        Order orderToBeRemoved = ordersService.get(0);
        shopService1.removeOrder(orderToBeRemoved.orderNumber());

        //Removes the first order in the shop service1
        Order orderToBeRemoved1 = ordersService1.get(0);
        shopService1.removeOrder(orderToBeRemoved1.orderNumber());

        //Prints out what is in the shop service
        System.out.println(shopService);
        System.out.println(shopService1);

        //Change the Order

    }

}
