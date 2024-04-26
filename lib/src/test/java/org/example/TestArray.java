package org.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.example.Array;
import static org.example.Array.*;
import static java.lang.System.out;


public class TestArray{
    // Declare the Array object.
    Array doubleArray;
    Array arrayOfArray;

    /**
     * Set up the test before 
     * running all test cases.
     */
    @Before public void setUp(){
        this.doubleArray = new Array<Double>(
		6.23, 71.2);
	this.arrayOfArray = new Array<Double>(
		this.doubleArray,
		this.doubleArray,
		array("hello", "world")
		);
    }
    /**
     * Test the toString method
     */
    @Test public void testToString(){
        assertEquals(
		doubleArray.toString(),
		"[6.23, 71.2]");
	assertEquals(
		array('a', 'b').toString(),
		"[a, b]");

	assertEquals(
	     arrayOfArray.toString(),
	     "[[6.23, 71.2], [6.23, 71.2], [hello, world]]"
	     );
	assertEquals(
	    array(
		array(2, 6, 7),
		array(2, 7, 1))
	    .toString(),
	    "[[2, 6, 7], [2, 7, 1]]"
	    );

    }
}
