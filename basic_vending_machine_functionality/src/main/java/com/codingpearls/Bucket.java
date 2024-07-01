package com.codingpearls;

import java.util.function.BiFunction;

/**
 * The Bucket class is a generic container that holds a pair of objects.
 *
 * @param <E1> the type of the first element
 * @param <E2> the type of the second element
 */
public class Bucket<E1, E2> {

    private final E1 firstElement;
    private final E2 secondElement;

    /**
     * Constructs a new Bucket with the specified elements.
     *
     * @param firstElement  the first element to be stored in the bucket
     * @param secondElement the second element to be stored in the bucket
     */
    public Bucket(E1 firstElement, E2 secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    /**
     * Returns the first element stored in the bucket.
     *
     * @return the first element
     */
    public E1 getFirstElement() {
        return firstElement;
    }

    /**
     * Returns the second element stored in the bucket.
     *
     * @return the second element
     */
    public E2 getSecondElement() {
        return secondElement;
    }

    /**
     * Applies a function to both elements of the bucket.
     *
     * @param <R>      the type of the result
     * @param function the function to apply to both elements
     * @return the result of applying the function to the elements
     */
    public <R> R apply(BiFunction<E1, E2, R> function) {
        return function.apply(firstElement, secondElement);
    }

    /**
     * Returns a string representation of the bucket.
     *
     * @return a string representation of the bucket
     */
    @Override
    public String toString() {
        return "Bucket{" +
               "firstElement=" + firstElement +
               ", secondElement=" + secondElement +
               '}';
    }
}
