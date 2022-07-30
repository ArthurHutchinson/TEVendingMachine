package com.techelevator.inventory;

import java.math.BigDecimal;

public class Munchy extends Item{


    //constructor
    public Munchy(String name, BigDecimal price, String location) {
        super(name, price, location);
    }

    @Override
    public String sillyMessage(){
        return "Munchy, Munchy, so Good!";
    }

}
