package org.example;

public interface Stats{
    /**
     * Computes the mean of the numeric array.
     * @return mean: mean of numeric array.
     */
    public double mean();

    /**
     * Computes the total sum of the array
     * @return total sum of the array
     */
    public double sum();

    /**
     * Represents the size of the array.
     * @return size the array.
     */
    public int size();
}
