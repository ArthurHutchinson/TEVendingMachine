package com.techelevator.reader;

import com.techelevator.inventory.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class SlotStockerTest {

    SlotStock slotStock = new SlotStock();

    Candy snorker = new Candy("Snorker", new BigDecimal("3.55"), "A1");
    Munchy chipPie = new Munchy("Chip Pie", new BigDecimal("2.23"), "A2");
    Gum fourGum = new Gum("4Gum", new BigDecimal("5.25"), "A3");

    Map<String, Item> inventory = new LinkedHashMap<>();

    @Before
    public void setup(){
        inventory.put("A1",snorker);
        inventory.put("A2",chipPie);
        inventory.put("A3",fourGum);

        slotStock.buildStartingInventory(inventory);
    }


    @Test
    public void build_inventory_test() {

        Assert.assertEquals(6, slotStock.amountInStock(snorker));
        Assert.assertEquals(6, slotStock.amountInStock(chipPie));
        Assert.assertEquals(6, slotStock.amountInStock(fourGum));
    }

    @Test
    public void subtract_two_from_available() {
        slotStock.updateInventoryStock(snorker);
        slotStock.updateInventoryStock(chipPie);
        slotStock.updateInventoryStock(chipPie);
        Assert.assertEquals(5,slotStock.amountInStock(snorker));
        Assert.assertEquals(4,slotStock.amountInStock(chipPie));
        Assert.assertEquals(6, slotStock.amountInStock(fourGum));
    }

}
