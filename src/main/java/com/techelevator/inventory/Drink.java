package com.techelevator.inventory;

import java.math.BigDecimal;

public class Drink extends Item {

    //constructor
    public Drink(String name, BigDecimal price, String location) {
        super(name, price, location);
    }

    //methods
    @Override
    public String sillyMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
