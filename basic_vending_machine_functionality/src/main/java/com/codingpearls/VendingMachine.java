package com.codingpearls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents a vending machine that manages items, coins, and transactions.
 */
public class VendingMachine {
    
    private Inventory<Item> itemInventory;
    private Inventory<Coin> cashInventory;
    private int currentBalance;
    private Item currentItem;

    public VendingMachine() {
        initialize();
    }

    private void initialize() {
        itemInventory = new Inventory<>();
        cashInventory = new Inventory<>();
        
        // Initialize with default items
        itemInventory.add(new Item("Soda", 100));
        itemInventory.add(new Item("Chips", 50));
        itemInventory.add(new Item("Candy", 25));
    }
    
    public Inventory<Item> getItemInventory() {
        return itemInventory;
    }

    public Inventory<Coin> getCashInventory() {
        return cashInventory;
    }

    /**
     * Selects an item and prepares for purchase.
     *
     * @param item the item to be purchased
     */
    public void selectItemAndGetPrice(Item item) {
        currentItem = item;
    }

    /**
     * Inserts a coin into the vending machine.
     *
     * @param coin the coin to be inserted
     */
    public void insertCoin(Coin coin) {
        currentBalance += coin.getDenomination();
        cashInventory.add(coin);
    }

    /**
     * Collects the selected item and any change due.
     *
     * @return a list of coins representing the change
     * @throws NotFullPaidException if the full price of the item has not been paid
     * @throws NotSufficientChangeException if there is not enough change available
     * @throws IllegalStateException if no item has been selected
     */
    public List<Coin> collectItemAndChange() {
        if (currentItem == null) {
            throw new IllegalStateException("No item selected");
        }

        if (currentBalance < currentItem.getPrice()) {
            throw new NotFullPaidException("Full amount not paid");
        }

        int changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount).orElseThrow(
                () -> new NotSufficientChangeException("Not enough change in the machine"));

        itemInventory.deduct(currentItem);
        cashInventory.deduct(change);
        currentBalance = 0;
        currentItem = null;

        return change;
    }

    /**
     * Calculates the change to be returned.
     *
     * @param amount the amount of change to be returned
     * @return a list of coins representing the change, or an empty Optional if there is insufficient change
     */
    private Optional<List<Coin>> getChange(int amount) {
        List<Coin> change = new ArrayList<>();
        while (amount > 0) {
            if (amount >= 25 && cashInventory.hasItem(new Coin(25))) {
                change.add(new Coin(25));
                amount -= 25;
            } else if (amount >= 10 && cashInventory.hasItem(new Coin(10))) {
                change.add(new Coin(10));
                amount -= 10;
            } else if (amount >= 5 && cashInventory.hasItem(new Coin(5))) {
                change.add(new Coin(5));
                amount -= 5;
            } else if (amount >= 1 && cashInventory.hasItem(new Coin(1))) {
                change.add(new Coin(1));
                amount -= 1;
            } else {
                return Optional.empty();
            }
        }
        return Optional.of(change);
    }

    /**
     * Refunds the current balance.
     *
     * @return a list of coins representing the refunded amount
     */
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance).orElse(new ArrayList<>());
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    /**
     * Resets the vending machine to its initial state.
     */
    public void reset() {
        itemInventory.clear();
        cashInventory.clear();
        currentBalance = 0;
        currentItem = null;
        initialize();
    }
}
