package com.techelevator.application;

import com.techelevator.inventory.Item;
import com.techelevator.money.Money;
import com.techelevator.reader.InventoryStocker;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
//TODO: Figure out issue of initializing map with values of 0 & getting map to persist between feed money calls
    private Map<String, Item> inventory;
    private Map<BigDecimal, Integer> userInputMoney = new HashMap<>();
    Money money = new Money();

    public VendingMachine(InventoryStocker inventoryStocker){
        inventory = inventoryStocker.getInventory();
    }

    public void run() {
        while(true) {
            userOutput.displayHomeScreen();
            userOutput.displayHomeScreenOptions();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                // display the items
                UserOutput.displayInventoryItems(inventory);
            }
            else if(choice.equals("purchase")) {
                // make a purchase
                userOutput.displayPurchaseScreenOptions();
                choice = userInput.getPurchaseScreenOption();
                if(choice.equals("feed")){
                    userOutput.displayFeedMoneyScreenOptions();
                    choice = userInput.getFeedMoneyScreenOption();
                    if(choice.equals("1")){
                        userInputMoney.put(money.get$1_DOllAR(), 0);
                        userInputMoney.put(money.get$1_DOllAR(), userInputMoney.get(money.get$1_DOllAR()) + 1);
                        System.out.println(money.currentMoneyInput(userInputMoney));
                    } else if(choice.equals("5")) {
                        userInputMoney.put(money.get$5_DOLLAR(), userInputMoney.get(money.get$5_DOLLAR()) + 1);
                        System.out.println(money.currentMoneyInput(userInputMoney));
                    } else if(choice.equals("10")) {
                        userInputMoney.put(money.get$10_DOLLAR(), userInputMoney.get(money.get$10_DOLLAR()) + 1);
                        System.out.println(money.currentMoneyInput(userInputMoney));
                    } else if(choice.equals("20")) {
                    userInputMoney.put(money.get$20_DOLLAR(), userInputMoney.get(money.get$20_DOLLAR()) + 1);
                        System.out.println(money.currentMoneyInput(userInputMoney));
                    } else if (choice.equals("e")) {
                        break;
                    }
                    //can continue feeding
                } else if(choice.equals("select")){
                    //return user to purchase menu
                }else if (choice.equals("finish")){
                    //complete transaction & return change
                }else {
                    break;
                }

            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }
}
