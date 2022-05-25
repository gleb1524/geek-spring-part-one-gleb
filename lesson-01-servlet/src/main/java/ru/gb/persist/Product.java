package ru.gb.persist;

public class Product {
    private Long id;
    private String title;
    private int cost;

    public Product(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String productName) {
        this.title = productName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = (int) cost;
    }
}
