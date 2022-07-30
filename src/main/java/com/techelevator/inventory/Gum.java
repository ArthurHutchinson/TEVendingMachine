package com.techelevator.inventory;

import java.math.BigDecimal;

public class Gum extends Item {

    //constructor
    public Gum(String name, BigDecimal price, String location) {
        super(name, price, location);
    }

    //methods
    @Override
    public String sillyMessage() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
