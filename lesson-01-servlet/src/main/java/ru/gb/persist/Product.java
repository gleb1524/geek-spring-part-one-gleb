package ru.gb.persist;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String productName;
    private int price;

    public Product(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = (int)price;
    }
}
