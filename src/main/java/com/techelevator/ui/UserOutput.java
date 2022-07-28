package com.techelevator.ui;

import com.techelevator.inventory.Item;

import java.util.Map;
import java.util.Formatter;

public class UserOutput {
    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

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

        System.out.println("D) Display Items");
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
        System.out.print("Please select an option: ");

        System.out.println();
        //TODO: add in code for displaying actual money
        System.out.println("Current Money Provided: $$$");
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
        System.out.print("Please select an option: ");

        System.out.println();
        //TODO: add in code for displaying actual money
        System.out.println("Current Money Provided: $$$");
    }



    //method to display inventory
    //TODO: Fix output appearance (tabbing, etc)

    public static void displayInventoryItems(Map<String, Item> inventory){
        String format1 = "%-20s%s%n";
        String format2 = "%-5s%s%n";
        System.out.println("##############################################");
        System.out.println("Item Location | Item | Price");
        System.out.println("----------------------------------------------");
        for (Map.Entry<String, Item> currentItem : inventory.entrySet()) {
            System.out.println(currentItem.getKey() + " | " + currentItem.getValue().getName() + " | $" + currentItem.getValue().getPrice());
            //System.out.format(format2, currentItem.getKey(), currentItem.getValue().getName(), currentItem.getValue().getPrice());
        }
        System.out.println("##############################################");
    }
}
