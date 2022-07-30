package com.techelevator.ui;

import com.techelevator.inventory.Item;
import com.techelevator.inventory.SlotStock;
import com.techelevator.money.UserWallet;

import java.util.Map;

public class UserOutput {

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayHomeScreenOptions() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public void displayPurchaseScreenOptions() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.println("Current Money Provided: " + UserWallet.getUserMoney());

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public void displayFeedMoneyScreenOptions() {
        System.out.println("What bill are you inserting?");
        System.out.println();

        System.out.println("1)  $1");
        System.out.println("5)  $5");
        System.out.println("10) $10");
        System.out.println("20) $20");
        System.out.println("E)  Exit");

        System.out.println();
        System.out.println("Current Money Provided: " + UserWallet.getUserMoney());

        System.out.println();
        System.out.print("Please select an option: ");
    }

    //method to display inventory
    public static void displayInventoryItems(Map<String, Item> inventory) {
        SlotStock stockedItemsA = new SlotStock();
        System.out.println("##############################################");
        System.out.println("Item Location | Item | Price | Quantity");
        System.out.println("----------------------------------------------");
        for (Map.Entry<String, Item> currentItem : inventory.entrySet()) {
            System.out.println(currentItem.getKey() + " | " + currentItem.getValue().getName() + " | $" + currentItem.getValue().getPrice() + " | " + stockedItemsA.getStockItems().get(currentItem.getValue()));
        }
        System.out.println("##############################################");
    }

    public void displaySelectionMenu() {
        System.out.println("Please type in the slot identifier (Example - A1): ");
    }
}