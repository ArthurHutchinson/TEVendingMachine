package com.techelevator.inventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class SlotStock {

    // Member Variables
    private int availableItems = 6;
    private static Map<Item, Integer> stockedInventory = new LinkedHashMap<>();

    // Constructor
    public SlotStock() {
    }

    // Methods
    public Map<Item, Integer> buildStartingInventory(Map<String, Item> inventory) {
        for (Map.Entry<String, Item> currentItem : inventory.entrySet()) {
            stockedInventory.put(currentItem.getValue(), availableItems);
        }
        return stockedInventory;
    }

    public void updateInventoryStock(Item item) {
        stockedInventory.put(item, stockedInventory.get(item) - 1);
    }

    public int amountInStock(Item item) {
        return stockedInventory.get(item);
    }

    // Getter & Setters
    public Map<Item, Integer> getStockItems() {
        return stockedInventory;
    }


}
