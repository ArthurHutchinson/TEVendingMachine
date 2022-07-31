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
        System.out.println("Current Money Provided: $" + UserWallet.getUserMoney());

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
        System.out.println("Current Money Provided: $" + UserWallet.getUserMoney());

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
            if(stockedItemsA.getStockItems().get(currentItem.getValue()) > 0){
            System.out.println(currentItem.getKey() + " | " + currentItem.getValue().getName() + " | $" + currentItem.getValue().getPrice() + " | " + stockedItemsA.getStockItems().get(currentItem.getValue()));

        } else {
                System.out.println(currentItem.getKey() + " | " + currentItem.getValue().getName() + " | $" + currentItem.getValue().getPrice() + " | " + "NO LONGER AVAILABLE");
            }
            }
        System.out.println("##############################################");
    }

    public void displaySelectionMenu() {
        System.out.println("Please type in the slot identifier (Example - A1): ");
    }

    public void displayItemDispensingMessage(Item selectedItem){
        System.out.println("Dispensing item: " + selectedItem.getName());
        System.out.println("Price: $ " + selectedItem.getPrice());
        System.out.println("Money remaining: $" + UserWallet.getUserMoney());
        System.out.println(selectedItem.sillyMessage());

    }

    public void itemNotAvailable(){
        System.out.println("This item is NO LONGER AVAILABLE.");
    }


    public void insertAdditionalMoney(){
        System.out.println("Please insert additional money.");
    }

    public void slotDoesNotExist(){
        System.out.println("The selected spot does not exist.");
    }

    public void enterValidBill(){
        System.out.println("Please enter a valid bill type.");
    }

    public void dispenseChangeMessage(int dollars, int quarters, int dimes, int nickels){
        System.out.println("Thanks for shopping! Here is your change!");
        System.out.println("Returning change: " + dollars + " $1(s), " + quarters + " quarter(s), " + dimes + " dime(s), " + nickels + " nickel(s).");
    }

    public void exitMessage(){
        System.out.println("Thanks for shopping with Taste Elevator!");
    }


}