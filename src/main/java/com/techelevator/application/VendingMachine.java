package com.techelevator.application;

import com.techelevator.inventory.Item;
import com.techelevator.inventory.SlotStock;
import com.techelevator.money.ChangeMachine;
import com.techelevator.money.Money;
import com.techelevator.money.UserWallet;
import com.techelevator.reader.InventoryStocker;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.writer.AuditTracker;

import java.util.Map;

public class VendingMachine implements Money {

    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    AuditTracker auditTracker = new AuditTracker();

    private Map<String, Item> inventory;
    private Map<Item, Integer> slotStock;
    public String choice;

    SlotStock slotStocker = new SlotStock();

    public VendingMachine(InventoryStocker inventoryStocker, SlotStock slotStocker) {
        inventory = inventoryStocker.getInventory();
        slotStock = slotStocker.buildStartingInventory(inventory);
    }

    public void mainMenu() {
        userOutput.displayHomeScreen();
        userOutput.displayHomeScreenOptions();
        choice = userInput.getHomeScreenOption();

        System.out.println(choice);
        switch (choice) {
            case "display":
                this.itemDisplayMenu();
            case "purchase":
                this.purchaseMenu();
            case "exit":
                userOutput.exitMessage();
                System.exit(0);
            case "":
                this.mainMenu();
        }
    }

    public void itemDisplayMenu() {
        UserOutput.displayInventoryItems(inventory);
        this.mainMenu();
    }

    public void purchaseMenu() {
        userOutput.displayPurchaseScreenOptions();
        choice = userInput.getPurchaseScreenOption();
        switch (choice) {
            case "feed":
                this.feedMenu();
            case "select":
                this.selectMenu();
            case "finish":
                this.finishMenu();
            case "":
                this.purchaseMenu();
        }
    }

    public void feedMenu() {
        userOutput.displayFeedMoneyScreenOptions();
        choice = userInput.getFeedMoneyScreenOption();
        if (choice.equals("1") | choice.equals("5") | choice.equals("10") | choice.equals("20")) {
            UserWallet.addToUserMoney(choice);
            System.out.println(UserWallet.getUserMoney());
            auditTracker.feedMoneyAudit(choice);
            this.feedMenu();
        } else if (choice.equals("exit")) {
            this.purchaseMenu();
        } else {
            userOutput.enterValidBill();
            this.feedMenu();
        }
    }

    public void selectMenu() {
        UserOutput.displayInventoryItems(inventory);
        userOutput.displaySelectionMenu();
        choice = userInput.getSelectMenuOption();
        Item selectedItem = inventory.get(choice);
        if (inventory.containsKey(choice)) {
            if (slotStocker.amountInStock(selectedItem) > 0 && UserWallet.getUserMoney().compareTo(selectedItem.getPrice()) >= 0) {
                slotStocker.updateInventoryStock(selectedItem);
                auditTracker.purchaseItemAudit(selectedItem);
                UserWallet.purchaseFromUserMoney(selectedItem);
                userOutput.displayItemDispensingMessage(selectedItem);
                this.purchaseMenu();
            } else if (slotStocker.amountInStock(selectedItem) <= 0) {
                userOutput.itemNotAvailable();
                this.purchaseMenu();
            } else if (UserWallet.getUserMoney().compareTo(selectedItem.getPrice()) < 0) {
                userOutput.insertAdditionalMoney();
                this.purchaseMenu();
            }

        } else {
            userOutput.slotDoesNotExist();
            this.purchaseMenu();
        }
    }

    public void finishMenu() {
        ChangeMachine changeMachine = new ChangeMachine();
        auditTracker.changeGivenAudit();
        changeMachine.makeChange(UserWallet.getUserMoney());
        userOutput.dispenseChangeMessage(changeMachine.getCountOfDollars(), changeMachine.getCountOfQuarters(), changeMachine.getCountOfDimes(), changeMachine.getCountOfNickels());
        this.mainMenu();
    }




}
