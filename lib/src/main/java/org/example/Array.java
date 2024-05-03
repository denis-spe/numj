package org.example;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Array<T> implements Stats, Iterable<T>{
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
     * This represents string values.
     * @param num: array values.
     * @return Array.
     */
    public static Array<String> array(String... num){
        return new Array<>(num);
    }

    /**
     * This represents character values.
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return this.useArrWithArr ?
                (Iterator<T>) this.arrWithArr.iterator() :
                this.arr.listIterator();
    }
}
