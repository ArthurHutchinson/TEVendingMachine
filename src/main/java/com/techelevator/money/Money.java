package com.techelevator.money;

import java.math.BigDecimal;

public interface Money {

    //member variables
    BigDecimal $20_DOLLAR = new BigDecimal(20.00);
    BigDecimal $10_DOLLAR = new BigDecimal(10.00);
    BigDecimal $5_DOLLAR = new BigDecimal(5.00);
    BigDecimal $1_DOLLAR = new BigDecimal(1.00);
    BigDecimal QUARTER = new BigDecimal(0.25);
    BigDecimal DIME = new BigDecimal(0.10);
    BigDecimal NICKEL = new BigDecimal(0.05);
}
