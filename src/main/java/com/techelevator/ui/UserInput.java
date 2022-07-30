package com.techelevator.ui;


import java.util.Locale;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("d")) {
            return "display";
        } else if (option.equals("p")) {
            return "purchase";
        } else if (option.equals("e")) {
            return "exit";
        } else {
            return "";
        }
    }

    public String getPurchaseScreenOption() {

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("m")) {
            return "feed";
        } else if (option.equals("s")) {
            return "select";
        } else if (option.equals("f")) {
            return "finish";
        } else {
            return "";
        }
    }

    public String getFeedMoneyScreenOption() {

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        System.out.println("option = " + option);
        if (option.equals("1")) {
            return "1";
        } else if (option.equals("5")) {
            return "5";
        } else if (option.equals("10")) {
            return "10";
        } else if (option.equals("20")) {
            return "20";
        } else if (option.equals("e")) {
            return "exit";
        } else {
            return "";
        }
    }

    public String getSelectMenuOption() {
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase(Locale.ROOT);
        System.out.println("option = " + option);

        return option;

    }
}