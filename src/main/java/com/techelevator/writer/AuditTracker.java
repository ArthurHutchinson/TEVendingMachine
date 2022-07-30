package com.techelevator.writer;

import com.techelevator.inventory.Item;
import com.techelevator.money.UserWallet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditTracker {

    //looked up how to format LocalDateTime
    private LocalDateTime currentDateAndTime = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy KK:mm:ss a");
    private String formattedDateTime = currentDateAndTime.format(formatter);

    private String auditFilePath = "Audit.txt";

    private File auditFile = new File(auditFilePath);

    public void feedMoneyAudit(String choice) {
        //looked up how to append to a file with FileWriter
        try (FileWriter fileWriter = new FileWriter(auditFile, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(">" + formattedDateTime + " MONEY FED: " + "$" + choice + ".00 $" + UserWallet.getUserMoney());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void purchaseItemAudit(Item item) {
        try (FileWriter fileWriter = new FileWriter(auditFile, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(">" + formattedDateTime + " " + item.getName() + " " + item.getLocation() + " $" + UserWallet.getUserMoney() + " $" + UserWallet.getUserMoney().subtract(item.getPrice()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeGivenAudit() {
        try (FileWriter fileWriter = new FileWriter(auditFile, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(">" + formattedDateTime + " CHANGE GIVEN: " + "$" + UserWallet.getUserMoney() + " $0.00");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


}
