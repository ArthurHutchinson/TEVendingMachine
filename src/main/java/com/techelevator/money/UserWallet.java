package com.techelevator.money;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UserWallet implements Money{

    private static Map<BigDecimal,Integer> userInputMoney = new HashMap<>();

    public UserWallet(){
        userInputMoney.put($1_DOLLAR, 0);
        userInputMoney.put($5_DOLLAR, 0);
        userInputMoney.put($10_DOLLAR, 0);
        userInputMoney.put($20_DOLLAR, 0);
    }

    //methods
    public static BigDecimal currentMoneyInput (Map<BigDecimal,Integer> userInputMoney){
        BigDecimal currentUserTotal = BigDecimal.valueOf(0.00);
        for(Map.Entry<BigDecimal,Integer> currentBill : userInputMoney.entrySet()){
            currentUserTotal = currentUserTotal.add(currentBill.getKey().multiply(BigDecimal.valueOf(currentBill.getValue())));
        }
        return currentUserTotal;
    }

    public static void updateUserInputMoney(BigDecimal userBill, Integer numberOfBills){
        userInputMoney.put(userBill, numberOfBills);
    }

    public static BigDecimal getBalance() {
        return currentMoneyInput(userInputMoney);
    }

    //getters & setters
    public static Map<BigDecimal, Integer> getUserInputMoney() {
        return userInputMoney;
    }

}
