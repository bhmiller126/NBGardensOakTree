package com.qa.oaktree;

import static org.junit.Assert.*;
import org.junit.Test;
import com.qa.oaktree.entities.Customer;

public class CustomerTest {
	
	@Test public void testCustomer () {
		Customer testing = new Customer (null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0); 
		assertNull(testing.getFirstName());
	}
	@Test public void testCustomerString() {
		Customer testing = new Customer(null, null, "a", null, null, null, null, null, null, null, null, null, null, false, 0); 
		assertNotNull(testing.getFirstName()); 
	}
	@Test public void testGetUserName () {
		Customer testing = new Customer(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0);
		assertNull(testing.getUserName()); 	
	}
	@Test public void testGetLastName() {
		Customer testing = new Customer(null, null, null, "a", null, null, null, null, null, null, null, null, null, false, 0); 
		assertEquals ("a", testing.getLastName()); 
	}
	@Test public void testSetName() {
		Customer testing = new Customer(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0); 
		testing.setUserName("aa");
		assertEquals("aa", testing.getUserName()); 
	}
	@Test public void testSetGender() {
		Customer testing = new Customer(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0); 
		testing.setGender(true);
		assertEquals(true, testing.isGender()); 
	}
	@Test public void testSetCredit() {
		Customer testing = new Customer(null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0); 
		testing.setCredit(0);
		testing.getCredit();
	}
}

