package com.techelevator.reader;

import com.techelevator.inventory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InventoryStocker {

    //method- create inventory from .csv
    public Map<String, Item> getInventory() {

        String filePath = "catering.csv";
        File inventoryFile = new File(filePath);

        Map<String, Item> inventory = new LinkedHashMap<>();

        try (Scanner fileScanner = new Scanner(inventoryFile)) {

            while (fileScanner.hasNextLine()) {

                String lineFromInventoryFile = fileScanner.nextLine();
                String[] inventoryItem = lineFromInventoryFile.split(",");

                Item item = null;

                if (inventoryItem[3].equals("Munchy")) {
                    item = new Munchy(inventoryItem[1], BigDecimal.valueOf(Double.parseDouble(inventoryItem[2])), inventoryItem[0]);
                } else if (inventoryItem[3].equals("Candy")) {
                    item = new Candy(inventoryItem[1], BigDecimal.valueOf(Double.parseDouble(inventoryItem[2])), inventoryItem[0]);
                } else if (inventoryItem[3].equals("Drink")) {
                    item = new Drink(inventoryItem[1], BigDecimal.valueOf(Double.parseDouble(inventoryItem[2])), inventoryItem[0]);
                } else if (inventoryItem[3].equals("Gum")) {
                    item = new Gum(inventoryItem[1], BigDecimal.valueOf(Double.parseDouble(inventoryItem[2])), inventoryItem[0]);
                }
                inventory.put(item.getLocation(), item);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return inventory;
    }
}
