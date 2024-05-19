package org.example;

public interface Stats{
    /**
     * Computes the mean of the numeric array.
     * @return mean: mean of numeric array.
     */
    double mean();

    /**
     * Computes the total sum of the array
     * @param axis: Integer for axis
     * @return total sum of the array
     */
    Object sum(int axis);

    /**
     * Computes the total sum of the array
     * @return total sum of the array
     */
    double sum();

    /**
     * Represents the size of the array.
     * @return size the array.
     */
    int size();
}
