package com.techelevator;


import com.techelevator.application.VendingMachine;
import com.techelevator.inventory.SlotStock;
import com.techelevator.reader.InventoryStocker;

public class VendingMachineCLI {

    public static void main(String[] args) {
        InventoryStocker inventoryStocker = new InventoryStocker();
        SlotStock slotStock = new SlotStock();
        VendingMachine vendingMachine = new VendingMachine(inventoryStocker, slotStock);
        vendingMachine.mainMenu();

    }
}
