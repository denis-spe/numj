package org.example;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

public class Array<T> implements Stats, Iterable<T>{
    // Class variable

    /**
     * List values
     */
    private List<T> arr;

    /**
     * List of arrays
     */
    private List<Array<?>> arrWithArr;
    /**
     * check whether to use arrWithArr or
     * arr of value variable
     */
    private final boolean useArrWithArr;

    // Constructor
    
    /**
     * Array constructor
     * @param num:(T) array values
     */
    @SafeVarargs
    public Array(T... num){
        this.arr = Arrays.asList(num);
	this.useArrWithArr = false;
    }
    /**
     * Array of array constructor
     * @param array:(Array<?>) array as arguments
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
     * @param str:(String) array values.
     * @return Array.
     */
    public static Array<String> array(String... str){
        return new Array<>(str);
    }

    /**
     * This represents character values.
     * @param character: (Character) array values.
     * @return Array.
     */
    public static Array<Character> array(Character... character){
        return new Array<>(character);
    }

    /**
     * This represent Arrays as values.
     * @param arrays: (Array<?>) array values.
     * @return Array of array.                 
     */
    public static Array<?> array(Array<?>... arrays){
        return new Array<>(arrays);
    }

    /**
     * Add element to the array.
     * @param element: (T) Element to the array.
     * @return (int) Size of the array.
     */
    public int add(T element){
        // Create a new arraylist
        ArrayList<T> arrayList = new ArrayList<>(this.arr);

        // Add the element to the array
        arrayList.add(element);

        // Assign the arrayList to the list
        this.arr = arrayList;
        return this.arr.size();
    }

    /**
     * Add element to the array
     * @param array: (Array<?>) Element to the array
     * @return (int) Size of the array.
     */
    public int add(Array<?> array){
        // Create a new arraylist
        ArrayList<Array<?>> arrayList = new ArrayList<>(this.arrWithArr);

        // Add the element to the array
        arrayList.add(array);

        // Assign the arrayList to the list
        this.arrWithArr = arrayList;

        return arrWithArr.size();
    }

    /**
     * Add element to the specified index.
     * @param index: (int) index to add the index.
     * @param array: (Array<?>) element to add to the array
     *  @return (int) Size of the array.
     */
    public int add(int index, Array<?> array){

        // Create a new arraylist
        ArrayList<Array<?>> arrayList = new ArrayList<>(this.arrWithArr);

        // Add the element to the array
        arrayList.add(index, array);

        // Assign the arrayList to the list
        this.arrWithArr = arrayList;

        return this.arrWithArr.size();
    }

    /**
     * Add element to the specified index.
     * @param index: (int) index to add the index.
     * @param element: (T) element to add to the array.
     *  @return (int) Size of the array.
     */
    public int add(int index, T element){
        // Create a new arraylist
        ArrayList<T> arrayList = new ArrayList<>(this.arr);

        // Add the element to the array
        arrayList.add(index, element);

        // Assign the arrayList to the list
        this.arr = arrayList;

        return this.arr.size();
    }

    /**
     * Computes the mean of the numeric array.
     * @return mean: (double) mean of numeric array.
     */
    @Override
    public double mean(){
	return 0.0;
    }

    /**
     * Computes the total sum of the array
     * @param axis: (int) Integer for axis
     * @return (Object) total sum of the array
     */
    @Override
    public Object sum(int axis){
        return null;
    }

    /**
     * Computes the total sum of the array
     * @return (double) total sum of the array
     */
    @Override
    public double sum() {
        return this.computeTheSum(this.arr);
    }

    public Double computeTheSum(@NotNull List<?> arr) {
        // Map to double then sum all the values
        var sum = arr.stream()
                .map(x -> Double.parseDouble(x.toString()))
                .reduce(Double::sum);

        // Create a Decimal format object
        DecimalFormat decimalFormat = new DecimalFormat("#0.000");

        return Double.parseDouble(
                decimalFormat.format(
                        sum.orElse(0.0)));
    }

    /**
     * Represents the size of the array.
     * @return (int) size the array.
     */
    @Override
    public int size() {
        return this.useArrWithArr ?
                this.arrWithArr.size() :
                this.arr.size();
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
