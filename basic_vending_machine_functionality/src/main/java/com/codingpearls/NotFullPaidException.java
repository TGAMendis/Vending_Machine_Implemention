package com.codingpearls;

/**
 * Exception thrown when the user has not paid the full amount required.
 */
public class NotFullPaidException extends RuntimeException {

    /**
     * Constructs a NotFullPaidException with the specified detail message.
     *
     * @param message the detail message
     */
    public NotFullPaidException(String message) {
        super(message);
    }
}
