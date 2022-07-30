package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Item {

    //member variables
    private String name;
    private BigDecimal price;
    private String location;


    //constructors
    public Item(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    //methods
    public String sillyMessage() {
        return "";
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

}
