package org.example;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Array<T> implements Stats, Iterator<T> {
    // Class variable
    /**
     * List values
     */
    List<T> arr;

    /**
     * List of arrays
     */
    List<Array<?>> arrWithArr;
    /**
     * check whether to use arrWithArr or
     * arr of value variable
     */
    boolean useArrWithArr;

    // Element index
    int elementIndex = 0;

    // Constructor
    
    /**
     * Array constructor
     * @param num: array values
     */
    @SafeVarargs
    public Array(T... num){
        this.arr = Arrays.asList(num);
	this.useArrWithArr = false;
    }
    /**
     * Array of array constructor
     * @param array: array as arguments
     */
    public Array(Array<?>... array){
       this.arrWithArr = Arrays.asList(array);
       this.useArrWithArr = true;
    }

    // Class method

    /**
     * This represent doubles values.
     * @param num: array values.
     * @return Array.
     */
    public static Array<Double> array(Double... num){
        return new Array<>(num);
    }

    /**
     * This represent integer values.
     * @param num: array values.
     * @return Array.
     */
    public static Array<Integer> array(Integer... num){
        return new Array<>(num);
    }

    /** 
     * This represent string values.
     * @param num: array values.
     * @return Array.
     */
    public static Array<String> array(String... num){
        return new Array<>(num);
    }

    /**
     * This represent character values.
     * @param values: array values.
     * @return Array.
     */
    public static Array<Character> array(Character... values){
        return new Array<>(values);
    }

    /**
     * This represent Arrays as values.
     * @param arrays: array values.
     * @return Array of array.                 
     */
    public static Array<?> array(Array<?>... arrays){
        return new Array<>(arrays);
    }

    @Override
    public boolean hasNext(){
        return this.useArrWithArr ?
                elementIndex < this.arrWithArr.size() :
                elementIndex < this.arr.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        if (hasNext()){
            return this.useArrWithArr ?
                    (T) this.arrWithArr.get(elementIndex++) :
                    this.arr.get(elementIndex++);
        }
        return null;
    }

    /**
     * Computes the mean of the numeric array.
     * @return mean: mean of numeric array.
     */
    @Override
    public double mean(){
	return 0.0;
    }

    /**
     * Computes the total sum of the array
     *
     * @return total sum of the array
     */
    @Override
    public double sum() {
        // Map to double then sum all the values
        var sum = this.arr.stream()
                .map(x -> Double.parseDouble(x.toString()))
                .reduce(Double::sum);

        // Create a Decimal format object
        DecimalFormat decimalFormat = new DecimalFormat("#0.000");

        return Double.parseDouble(
                decimalFormat.format(
                        sum.orElse(0.0)));
    }

    @Override
    public String toString(){
       return this.useArrWithArr ?
		this.arrWithArr
			.toString() : 
		this.arr.toString();
    }
}
