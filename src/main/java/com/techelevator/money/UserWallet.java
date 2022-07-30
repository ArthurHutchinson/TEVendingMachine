package com.techelevator.money;

import com.techelevator.inventory.Item;

import java.math.BigDecimal;

public class UserWallet implements Money {

    //member variables
    private static BigDecimal userMoney = new BigDecimal("0.00");

    //methods
    public static void addToUserMoney(String amountToAdd) {
        if (amountToAdd.equals("1")) {
            userMoney = userMoney.add($1_DOLLAR);
        } else if (amountToAdd.equals("5")) {
            userMoney = userMoney.add($5_DOLLAR);
        } else if (amountToAdd.equals("10")) {
            userMoney = userMoney.add($10_DOLLAR);
        } else if (amountToAdd.equals("20")) {
            userMoney = userMoney.add($20_DOLLAR);
        }
    }

    public static void purchaseFromUserMoney(Item item) {
        userMoney = userMoney.subtract(item.getPrice());
    }

    //getters & setters
    public static BigDecimal getUserMoney() {
        return userMoney;
    }

    public static void setUserMoney(BigDecimal userMoney) {
        UserWallet.userMoney = userMoney;
    }

}
