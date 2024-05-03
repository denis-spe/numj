package org.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.example.Array.*;
import static java.lang.System.out;


public class TestArray{
    // Declare the Array object.
    Array<?> doubleArray;
    Array<?> arrayOfArray;

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

	@Test public void testSum(){
        assertEquals(6, array(1, 4, 1).sum(), 0.0);
		assertEquals(10, array(1, 4, 1, 4).sum(), 0.0);
		assertEquals(8.2, array(2.2, 4.9, 1.1).sum(), 0.0);
	}

	@Test public void testNext(){
		for (Object value: array(array(4, 9), array(77, 9, 0), array(76, 9, 3))){
			out.println(value);
		}
	}
}
