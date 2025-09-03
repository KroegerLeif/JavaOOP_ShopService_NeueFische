package org.example;

import java.math.BigDecimal;

public record Order(String orderNumber,
                    BigDecimal totalPrice) {
}
