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

	@Test public void testIterator(){
		for (Integer num: array(2)){
			assertEquals(num, 2, 0);
		}
	}

	@Test public void testSize(){
		assertEquals(array(23, 4, 3).size(), 3);
		assertEquals(array(array(21, 3), array(1.23, 123.1)).size(), 2);
	}
}
