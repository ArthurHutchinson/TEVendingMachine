package com.techelevator.inventory;

import java.math.BigDecimal;

public class Candy extends Item{


    //constructor
    public Candy(String name, BigDecimal price, String location) {
        super(name, price, location);
    }

    //methods
    @Override
    public String sillyMessage(){
        return "Sugar, Sugar, so Sweet!";
    }

}
