package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRepo {
    private String name;
    private ArrayList<Product> products;


    public ProductRepo(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    //Boilerplate Code
    //Getter
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductRepo that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

}
