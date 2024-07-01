package com.codingpearls;

import java.util.Objects;

/**
 * The Item class represents a product in the vending machine with a name and price.
 */
public class Item {

    private String name;
    private int price;

    /**
     * Default constructor for Item.
     */
    public Item() {
        // Default constructor
    }

    /**
     * Parameterized constructor for creating an item with a specific name and price.
     *
     * @param name  the name of the item
     * @param price the price of the item
     */
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Checks if this item is equal to another object.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return Objects.equals(name, item.name);
    }

    /**
     * Returns the hash code of this item.
     *
     * @return the hash code of this item
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
