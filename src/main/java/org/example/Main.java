package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Product product = new Product("Kaffe", new BigDecimal("1.50"));
        Product product2 = new Product("Brot", new BigDecimal("0.50"));
        Product product3 = new Product("Milch", new BigDecimal("0.75"));
        Product product4 = new Product("Bier", new BigDecimal("2.00"));
        Product product5 = new Product("Schokolade", new BigDecimal("0.80"));
        Product product6 = new Product("Tee", new BigDecimal("1.00"));

        ProductRepo repoProduct = new ProductRepo("Shop");
        repoProduct.addProduct(product);
        repoProduct.addProduct(product2);
        repoProduct.addProduct(product3);
        repoProduct.addProduct(product4);
        repoProduct.addProduct(product5);
        repoProduct.addProduct(product6);

        OrderRepo repoMap = new OrderMapRepo();
        OrderRepo repoList = new OrderListRepo();

        ShopService shopService = new ShopService(repoProduct,repoMap);
        ShopService shopService1 = new ShopService(repoProduct,repoList);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        shopService.placeNewOrder(productList);
        shopService1.placeNewOrder(productList);

        System.out.println(shopService);
        System.out.println(shopService1);

    }

}
