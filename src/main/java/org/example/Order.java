package org.example;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }
}
