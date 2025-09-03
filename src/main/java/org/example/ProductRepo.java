package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRepo {
    private ArrayList<Product> products;

    //Konstruktor
    public ProductRepo(String name) {
        products = new ArrayList<>();
    }

    //Methoden
    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public boolean containsProduct(Product product) {
        return products.contains(product);
    }

    //Boilerplate Code
    //Getter
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductRepo that)) return false;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

}
