package com.techelevator.money;

import java.math.BigDecimal;

public interface Money {

    //member variables
    final BigDecimal $20_DOLLAR = BigDecimal.valueOf(20.00);
    final BigDecimal $10_DOLLAR = BigDecimal.valueOf(10.00);
    final BigDecimal $5_DOLLAR = BigDecimal.valueOf(5.00);
    final BigDecimal $1_DOLLAR = BigDecimal.valueOf(1.00);
    final BigDecimal QUARTER = BigDecimal.valueOf(0.25);
    final BigDecimal DIME = BigDecimal.valueOf(0.10);
    final BigDecimal NICKEL = BigDecimal.valueOf(0.05);
}
