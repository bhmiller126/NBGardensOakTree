package com.qa.oaktree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.qa.oaktree.entities.Customer;

/**
 * Test class that tests constructors and a couple of getters and setters 
 * @author Angus
 *
 */
public class CustomerTest {
	
	/**
	 * Tests default constructor create a new customer with a empty first name
	 */
	@Test public void testCustomer () {
		Customer testing = new Customer (); 
		assertEquals("", testing.getFirstName());
	}
	
	/**
	 * calls the full constructor and tests that the first name is saved and returned correctly
	 */
	@Test public void testCustomerString() {
		Customer testing = new Customer("", "", "a", "", "", null, true, null, "", "", "", "", "", "", ""); 
		assertEquals("a", testing.getFirstName()); 
	}
	
	/**
	 * tests full constructor saves and returns a user name correctly
	 */
	@Test public void testGetUserName () {
		Customer testing = new Customer("a", "", "", "", "", null, true, null, "", "", "", "", "", "", "");
		assertNull(testing.getUserName()); 	
	}
	
	/**
	 * tests full constructor saves and returns a users last name correctly 
	 */
	@Test public void testGetLastName() {
		Customer testing = new Customer("", "", "", "a", "", null, true, null, "", "", "", "", "", "", ""); 
		assertEquals ("a", testing.getLastName()); 
	}
	
	/**
	 * call the null constructor and then changes the blank name before testing it updated
	 */
	@Test public void testSetName() {
		Customer testing = new Customer(); 
		testing.setUserName("aa");
		assertEquals("aa", testing.getUserName()); 
	}
	
	/**
	 * calls the null constructor and then tests the setter and getter for gender
	 */
	@Test public void testSetGender() {
		Customer testing = new Customer(); 
		testing.setGender(true);
		assertEquals(true, testing.isGender()); 
	}
	
	/**
	 * calls the null constructor and then tests the setter and getter for credit
	 */
	@Test public void testSetCredit() {
		Customer testing = new Customer(); 
		BigDecimal testNum = new BigDecimal("1098.14");
		testing.setCredit(testNum);
		assertEquals(testNum, testing.getCredit());
	}
}

