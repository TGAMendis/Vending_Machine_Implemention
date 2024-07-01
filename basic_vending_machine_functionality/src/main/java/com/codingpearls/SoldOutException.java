package com.codingpearls;

/**
 * Exception thrown when an item in the vending machine is sold out.
 */
public class SoldOutException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	/**
     * Constructs a SoldOutException with the specified detail message.
     *
     * @param message the detail message
     */
    public SoldOutException(String message) {
        super(message);
    }
}
