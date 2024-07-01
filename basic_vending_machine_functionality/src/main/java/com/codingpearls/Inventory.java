package com.codingpearls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Inventory class manages a collection of items and their quantities.
 *
 * @param <T> the type of items in the inventory
 */
public class Inventory<T> {

    private final Map<T, Integer> inventory = new HashMap<>();

    /**
     * Gets the quantity of the specified item.
     *
     * @param item the item to check
     * @return the quantity of the item
     */
    public int getQuantity(T item) {
        return inventory.getOrDefault(item, 0);
    }

    /**
     * Adds an item to the inventory.
     *
     * @param item the item to add
     */
    public void add(T item) {
        inventory.merge(item, 1, Integer::sum);
    }

    /**
     * Deducts one unit of the specified item from the inventory.
     *
     * @param item the item to deduct
     */
    public void deduct(T item) {
        inventory.computeIfPresent(item, (key, count) -> (count > 1) ? count - 1 : null);
    }

    /**
     * Deducts a list of items from the inventory.
     *
     * @param items the list of items to deduct
     */
    public void deduct(List<T> items) {
        items.forEach(this::deduct);
    }

    /**
     * Checks if the inventory has the specified item.
     *
     * @param item the item to check
     * @return true if the item is in the inventory, false otherwise
     */
    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }

    /**
     * Clears the inventory.
     */
    public void clear() {
        inventory.clear();
    }

    /**
     * Gets the set of items in the inventory.
     *
     * @return the set of items in the inventory
     */
    public Set<T> getItems() {
        return inventory.keySet();
    }
}
