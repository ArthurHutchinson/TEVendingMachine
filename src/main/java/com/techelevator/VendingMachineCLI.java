package com.techelevator;


import com.techelevator.application.VendingMachine;
import com.techelevator.reader.InventoryStocker;

public class VendingMachineCLI {

	public static void main(String[] args) {
		InventoryStocker inventoryStocker = new InventoryStocker();
		VendingMachine vendingMachine = new VendingMachine(inventoryStocker);
		vendingMachine.run();

	}
}
