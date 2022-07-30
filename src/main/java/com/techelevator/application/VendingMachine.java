package com.techelevator.application;

import com.techelevator.inventory.Item;
import com.techelevator.inventory.SlotStock;
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

    SlotStock testingBuild = new SlotStock();

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
        testingBuild.buildStartingInventory(inventory);
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
                this.selectMenu();
            case "finish":
                // Complete transaction and return change.
                this.finishMenu();
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
                this.feedMenu();
            } else if (choice.equals("5")) {
                userWallet.updateUserInputMoney($5_DOLLAR, userWallet.getUserInputMoney().get($5_DOLLAR) + 1);
            } else if (choice.equals("10")) {
                userWallet.updateUserInputMoney($10_DOLLAR, userWallet.getUserInputMoney().get($10_DOLLAR) + 1);
            } else if (choice.equals("20")) {
                userWallet.updateUserInputMoney($20_DOLLAR, userWallet.getUserInputMoney().get($20_DOLLAR) + 1);
            } else if (choice.equals("exit")) {
                // TODO: Either remove the while loop and manually loop it OR fix this else-if statement so it returns back to purchase menu.
                loop = false;
                this.purchaseMenu();
            }
        }
    }

    public void selectMenu() {
        testingBuild.buildStartingInventory(inventory);
        UserOutput.displayInventoryItems(inventory);
        userOutput.displaySelectionMenu();
        choice = userInput.getSelectMenuOption();
        for(Map.Entry<String,Item> currentItem : inventory.entrySet()) {
            if(choice.equals(currentItem.getKey())) {
                System.out.println("This is a test" + currentItem.getValue().getName());
                System.out.println(currentItem.getValue().sillyMessage());
                this.purchaseMenu();
//            } else {
//                System.out.println("The selected spot does not exist");
            }
        }
    }

    public void finishMenu(){
        System.out.println("Finish him!");
    }

}
