package org.example;

import java.util.List;
import java.util.Arrays;

public class Array<T> implements Stats{
    // Class variable
    /**
     * List values
     */
    List<T> arr;

    /**
     * List of arrays
     */
    List<Array> arrWithArr;
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
    public Array(T... num){
        this.arr = Arrays.asList(num);
	this.useArrWithArr = false;
    }
    /**
     * Array of array constructor
     * @param array: array as arguments
     */
    public Array(Array... array){
       this.arrWithArr = Arrays.asList(array);
       this.useArrWithArr = true;
    }

    // Class method

    /**
     * This represent doubles values.
     * @param num: array values.
     * @return Array.
     */
    public static Array array(Double... num){
        return new Array<Double>(num);
    }

    /**
     * This represent integer values.
     * @param num: array values.
     * @return Array.
     */
    public static Array array(Integer... num){
        return new Array<Integer>(num);
    }

    /** 
     * This represent string values.
     * @param num: array values.
     * @return Array.
     */
    public static Array array(String... num){
        return new Array<String>(num);
    }

    /**
     * This represent character values.
     * @param values: array values.
     * @return Array.
     */
    public static Array array(Character... values){
        return new Array<Character>(values);
    }

    /**
     * This represent Arrays as values.
     * @param values: array values.
     * @return Array of array.                 
     */
    public static Array array(Array... arrays){
        return new Array<Object>(arrays);
    }

    /**
     * Computes the mean of the numeric array.
     * @return mean: mean of numeric array.
     */
    @Override
    public double mean(){
	return 0.0;
    }

    @Override
    public String toString(){
       return this.useArrWithArr ?
		this.arrWithArr
			.toString() : 
		this.arr.toString();
    }
}
