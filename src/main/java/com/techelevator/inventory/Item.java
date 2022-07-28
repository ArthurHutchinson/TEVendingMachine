package com.techelevator.inventory;

import java.math.BigDecimal;

public abstract class Item {

    //member variables
    private String name;
    private BigDecimal price;
    private String location;


    //constructors
    public Item(String name, BigDecimal price, String location){
        this.name = name;
        this.price = price;
        this.location = location;
    }

    //methods

    //getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
