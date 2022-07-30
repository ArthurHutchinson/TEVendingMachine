package com.techelevator.inventory;

import com.techelevator.inventory.Item;
import com.techelevator.reader.InventoryStocker;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SlotStock {

    // Member Variables

    private int availableItems = 6;
    //<location of item, count of item>
    static Map<Item, Integer> stockedInventory = new LinkedHashMap<>();
//    InventoryStocker test = new InventoryStocker();

    // Constructor
    public SlotStock() {
    }

    // Methods
    //<location, item object>
    public Map<Item, Integer> buildStartingInventory(Map<String, Item> inventory) {
        //TODO: Set this up:
       for (Map.Entry<String, Item> currentItem : inventory.entrySet()) {
           stockedInventory.put(currentItem.getValue(), availableItems);
       }
       return stockedInventory;
    }

    // Getter & Setters

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public Map<Item, Integer> getStockItems() {
        return stockedInventory;
    }

    public void setStockItems(Map<Item, Integer> stockItems) {
        this.stockedInventory = stockItems;
    }

    // Derived

}
