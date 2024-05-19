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
        this.doubleArray = new Array<>(
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

	@Test public void testAdd(){

		// Testing adding integer
		var arr = array(9, 0);
		assertEquals(arr.add(3), 3);
		assertEquals(arr.add(0, 10), 4);

		// Testing adding String
		var str = array("0", "1");
		assertEquals(str.add("3"), 3);
		assertEquals(str.add(0, "10"), 4);

		// Testing adding Array of Array
		var arrOfArr = array(array('0', '1'), array("0", "1"));
		assertEquals(arrOfArr.add(array(9, 0)), 3);
		assertEquals(arrOfArr.add(0, array(9.8, 9.6)), 4);


	}

	@Test public void testSum(){
//		out.println(array(1, 4, 1).sum());
        assertEquals(6.0, array(1, 4, 1).sum(), 0.0);
//		out.println(
//				array(
//				array(9, 8),
//				array(0, 8)
//				).sum(1)
//		);
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
