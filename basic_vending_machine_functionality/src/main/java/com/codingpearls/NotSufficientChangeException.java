package com.codingpearls;

/**
 * Exception thrown when there is not enough change in the vending machine to provide to the user.
 */
public class NotSufficientChangeException extends RuntimeException {

    /**
     * Constructs a NotSufficientChangeException with the specified detail message.
     *
     * @param message the detail message
     */
    public NotSufficientChangeException(String message) {
        super(message);
    }
}
