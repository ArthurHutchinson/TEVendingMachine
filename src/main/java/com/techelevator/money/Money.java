package com.techelevator.money;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Money {

    //member variables
    private final BigDecimal $20_DOLLAR = BigDecimal.valueOf(20.00);
    private final BigDecimal $10_DOLLAR = BigDecimal.valueOf(10.00);
    private final BigDecimal $5_DOLLAR = BigDecimal.valueOf(5.00);
    private final BigDecimal $1_DOllAR = BigDecimal.valueOf(1.00);
    private final BigDecimal QUARTER = BigDecimal.valueOf(0.25);
    private final BigDecimal DIME = BigDecimal.valueOf(0.10);
    private final BigDecimal NICKEL = BigDecimal.valueOf(0.05);

    Map<BigDecimal,Integer> userInputMoney = new HashMap<>();

    //methods
    public BigDecimal currentMoneyInput (Map<BigDecimal,Integer> userInputMoney){
        BigDecimal currentUserTotal = BigDecimal.valueOf(0.00);
        for(Map.Entry<BigDecimal,Integer> currentBill : userInputMoney.entrySet()){
            currentUserTotal = currentBill.getKey().multiply(BigDecimal.valueOf(currentBill.getValue()));
        }
        return currentUserTotal;
    }


    //getBalance

    //getters & setters

    public BigDecimal get$20_DOLLAR() {
        return $20_DOLLAR;
    }

    public BigDecimal get$10_DOLLAR() {
        return $10_DOLLAR;
    }

    public BigDecimal get$5_DOLLAR() {
        return $5_DOLLAR;
    }

    public BigDecimal get$1_DOllAR() {
        return $1_DOllAR;
    }

    public BigDecimal getQUARTER() {
        return QUARTER;
    }

    public BigDecimal getDIME() {
        return DIME;
    }

    public BigDecimal getNICKEL() {
        return NICKEL;
    }
}
