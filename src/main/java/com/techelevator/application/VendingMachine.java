package com.techelevator.application;

import com.techelevator.inventory.Item;
import com.techelevator.money.Money;
import com.techelevator.money.UserWallet;
import com.techelevator.reader.InventoryStocker;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements Money {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    UserWallet userWallet = new UserWallet();

    private Map<String, Item> inventory;
    public String choice;

    public VendingMachine(InventoryStocker inventoryStocker){
        inventory = inventoryStocker.getInventory();
    }

    public void mainMenu () {
        userOutput.displayHomeScreen();
        userOutput.displayHomeScreenOptions();
        choice = userInput.getHomeScreenOption();

        System.out.println(choice);
        switch(choice) {
            case "display":
                this.itemDisplayMenu();
            case "purchase":
                this.purchaseMenu();
            case "exit":
                // Exits Program Goodbye
                // Probably could do a System.exit(0) to close the entire program here.
        }

    }

    public void itemDisplayMenu () {
        UserOutput.displayInventoryItems(inventory);
        this.mainMenu();
    }

    public void purchaseMenu() {
        userOutput.displayPurchaseScreenOptions();
        choice = userInput.getPurchaseScreenOption();
        switch(choice) {
            case "feed":
                this.feedMenu();
            case "select":
                // Returns user to purchase menu.
            case "finish":
                // Complete transaction and return change.
        }
    }

    public void feedMenu() {
        boolean loop = true;
        while(loop) {
            userOutput.displayFeedMoneyScreenOptions();
            choice = userInput.getFeedMoneyScreenOption();
            if (choice.equals("1")) {
                userWallet.updateUserInputMoney($1_DOLLAR, userWallet.getUserInputMoney().get($1_DOLLAR) + 1);
                System.out.println(userWallet.currentMoneyInput(userWallet.getUserInputMoney()));
            } else if (choice.equals("5")) {
                userWallet.updateUserInputMoney($5_DOLLAR, userWallet.getUserInputMoney().get($5_DOLLAR) + 1);
            } else if (choice.equals("10")) {
                userWallet.updateUserInputMoney($10_DOLLAR, userWallet.getUserInputMoney().get($10_DOLLAR) + 1);
            } else if (choice.equals("20")) {
                userWallet.updateUserInputMoney($20_DOLLAR, userWallet.getUserInputMoney().get($20_DOLLAR) + 1);
            } else if (choice.equals("e")) {
                // TODO: Either remove the while loop and manually loop it OR fix this else-if statement so it returns back to purchase menu.
                loop = false;
                this.purchaseMenu();
            }
        }
    }

//    public void run() {
//        while(true) {
//            userOutput.displayHomeScreen();
//            userOutput.displayHomeScreenOptions();
//            String choice = userInput.getHomeScreenOption();
//
//            System.out.println(choice);
//            if(choice.equals("display")) {
//                // display the items
//                UserOutput.displayInventoryItems(inventory);
//            }
//            else if(choice.equals("purchase")) {
//                // make a purchase
//                userOutput.displayPurchaseScreenOptions();
//                choice = userInput.getPurchaseScreenOption();
//                if(choice.equals("feed")){
//                    while(true) {
//                        userOutput.displayFeedMoneyScreenOptions();
//                        choice = userInput.getFeedMoneyScreenOption();
//                        if (choice.equals("1")) {
//                            userInputMoney.put(money.get$1_DOLLAR(), 0);
//                            userInputMoney.put(money.get$1_DOLLAR(), userInputMoney.get(money.get$1_DOLLAR()) + 1);
//                            System.out.println(money.currentMoneyInput(userInputMoney));
//                        } else if (choice.equals("5")) {
//                            userInputMoney.put(money.get$5_DOLLAR(), 0);
//                            userInputMoney.put(money.get$5_DOLLAR(), userInputMoney.get(money.get$5_DOLLAR()) + 1);
//                            System.out.println(money.currentMoneyInput(userInputMoney));
//                        } else if (choice.equals("10")) {
//                            userInputMoney.put(money.get$10_DOLLAR(), 0);
//                            userInputMoney.put(money.get$10_DOLLAR(), userInputMoney.get(money.get$10_DOLLAR()) + 1);
//                            System.out.println(money.currentMoneyInput(userInputMoney));
//                        } else if (choice.equals("20")) {
//                            userInputMoney.put(money.get$20_DOLLAR(), 0);
//                            userInputMoney.put(money.get$20_DOLLAR(), userInputMoney.get(money.get$20_DOLLAR()) + 1);
//                            System.out.println(money.currentMoneyInput(userInputMoney));
//                        } else if (choice.equals("e")) {
//                            break;
//                        }
//                    }
//                    //can continue feeding
//                } else if(choice.equals("select")){
//                    //return user to purchase menu
//                }else if (choice.equals("finish")){
//                    //complete transaction & return change
//                }else {
//                    break;
//                }
//
//            }
//            else if(choice.equals("exit")) {
//                // good bye
//                break;
//            }
//        }
//    }
}
