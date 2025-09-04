package org.example;

import java.math.BigDecimal;
import java.util.HashMap;

public record Order(String orderNumber,
                    HashMap<Product, Integer> products,
                    BigDecimal totalPrice) {}
