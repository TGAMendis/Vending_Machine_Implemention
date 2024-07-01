package com.codingpearls;

/**
 * The Coin class represents a coin with a specific denomination.
 */
public class Coin {

    private int denomination;

    /**
     * Default constructor for the Coin class.
     * This constructor is used when creating a Coin object without specifying a denomination.
     */
    public Coin() {
        // Default constructor
    }

    /**
     * Constructs a Coin with the specified denomination.
     *
     * @param denomination the value of the coin
     */
    public Coin(int denomination) {
        this.denomination = denomination;
    }

    /**
     * Returns the denomination of the coin.
     *
     * @return the denomination of the coin
     */
    public int getDenomination() {
        return denomination;
    }

    /**
     * Returns the value of the coin, which is the same as denomination.
     *
     * @return the value of the coin
     */
    public int getValue() {
        return denomination;
    }
}
