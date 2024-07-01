package com.codingpearls;

import java.util.List;

/**
 * Main class to execute test cases for the VendingMachine.
 */
public class VendingMachineMaster {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Happy path scenarios
        System.out.println("Happy Path Scenarios:");

        // Selecting an item
        System.out.println("Selecting an Item:");
        Item item = new Item("Soda", 100);
        System.out.println("Expected Outcome: Price of selected item: 100");
        vendingMachine.selectItemAndGetPrice(item);

        // Inserting coins
        System.out.println("Inserting Coins:");
        vendingMachine.insertCoin(new Coin(25));
        vendingMachine.insertCoin(new Coin(25));
        vendingMachine.insertCoin(new Coin(50));

        // Collecting item and change
        System.out.println("Collecting Item and Change:");
        System.out.println("Expected Outcome: Dispensed item: Soda, Change: []");
        try {
            List<Coin> change = vendingMachine.collectItemAndChange();
            System.out.println("Change: " + change);
        } catch (NotFullPaidException | NotSufficientChangeException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Exception scenarios
        System.out.println("Exception Scenarios:");

        // Item sold out
        System.out.println("Item Sold Out:");
        try {
            vendingMachine.selectItemAndGetPrice(new Item("Water", 50));
        } catch (SoldOutException e) {
            System.out.println("Throws: " + e.getMessage());
        }

        // Not fully paid
        System.out.println("Not Fully Paid:");
        try {
            vendingMachine.insertCoin(new Coin(25));
            List<Coin> change = vendingMachine.collectItemAndChange();
            System.out.println("Change: " + change);
        } catch (NotFullPaidException e) {
            System.out.println("Throws: " + e.getMessage());
        } catch (NotSufficientChangeException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // No sufficient change
        System.out.println("No Sufficient Change:");
        try {
            vendingMachine.insertCoin(new Coin(100));
            List<Coin> change = vendingMachine.collectItemAndChange();
            System.out.println("Change: " + change);
        } catch (NotSufficientChangeException e) {
            System.out.println("Throws: " + e.getMessage());
        } catch (NotFullPaidException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
