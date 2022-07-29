package com.techelevator.inventory;

import com.techelevator.inventory.Item;
import com.techelevator.reader.InventoryStocker;

import java.util.HashMap;
import java.util.Map;

public class SlotStock {

    // Member Variables

    private int availableItems = 6;
    Map<String, Integer> inventory = new HashMap<>();
    InventoryStocker test = new InventoryStocker();

    // Constructor
    public SlotStock() {
    }

    // Methods
    public void getAvailableInventory(Map<String, Item> inventory) {
        //TODO: Set this up:
        //         for (Map.Entry<String, Item> currentItem : inventory.entrySet()) {
        // Could help who knows.


    }

    // Getter & Setters

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public Map<String, Integer> getStockItems() {
        return inventory;
    }

    public void setStockItems(Map<String, Integer> stockItems) {
        this.inventory = inventory;
    }

    // Derived

}
