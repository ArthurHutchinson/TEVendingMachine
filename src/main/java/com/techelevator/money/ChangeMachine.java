package com.techelevator.money;

import java.math.BigDecimal;

public class ChangeMachine implements Money {

    //member variables
    private int countOfDollars = 0;
    private int countOfQuarters = 0;
    private int countOfDimes = 0;
    private int countOfNickels = 0;

    //methods
    public void makeChange(BigDecimal userMoney) {
        BigDecimal balanceToReturn = userMoney;
        while (balanceToReturn.subtract($1_DOLLAR).compareTo(new BigDecimal("0.00")) >= 0) {
            balanceToReturn = balanceToReturn.subtract($1_DOLLAR);
            countOfDollars++;
        }
        while (balanceToReturn.subtract(QUARTER).compareTo(new BigDecimal("0.00")) >= 0) {
            balanceToReturn = balanceToReturn.subtract(QUARTER);
            countOfQuarters++;
        }
        while (balanceToReturn.subtract(DIME).compareTo(new BigDecimal("0.00")) >= 0) {
            balanceToReturn = balanceToReturn.subtract(DIME);
            countOfDimes++;
        }
        while (balanceToReturn.subtract(NICKEL).compareTo(new BigDecimal("0.00")) >= 0) {
            balanceToReturn = balanceToReturn.subtract(NICKEL);
            countOfNickels++;
        }
        UserWallet.setUserMoney(balanceToReturn);
    }

    //getters
    public int getCountOfDollars() {
        return countOfDollars;
    }

    public int getCountOfQuarters() {
        return countOfQuarters;
    }

    public int getCountOfDimes() {
        return countOfDimes;
    }

    public int getCountOfNickels() {
        return countOfNickels;
    }
}
