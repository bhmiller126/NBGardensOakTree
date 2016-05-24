package com.qa.oaktree;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.Test;
import com.qa.oaktree.entities.Customer;

public class CustomerTest {
	
	@Test public void testCustomer () {
		Customer testing = new Customer (); 
		assertEquals("", testing.getFirstName());
	}
	@Test public void testCustomerString() {
		Customer testing = new Customer("", "", "a", "", "", null, true, null, "", "", "", "", "", "", ""); 
		assertEquals("a", testing.getFirstName()); 
	}
	@Test public void testGetUserName () {
		Customer testing = new Customer("a", "", "", "", "", null, true, null, "", "", "", "", "", "", "");
		assertNull(testing.getUserName()); 	
	}
	@Test public void testGetLastName() {
		Customer testing = new Customer("", "", "", "a", "", null, true, null, "", "", "", "", "", "", ""); 
		assertEquals ("a", testing.getLastName()); 
	}
	@Test public void testSetName() {
		Customer testing = new Customer(); 
		testing.setUserName("aa");
		assertEquals("aa", testing.getUserName()); 
	}
	@Test public void testSetGender() {
		Customer testing = new Customer(); 
		testing.setGender(true);
		assertEquals(true, testing.isGender()); 
	}
	@Test public void testSetCredit() {
		Customer testing = new Customer(); 
		BigDecimal testNum = new BigDecimal("1098.14");
		testing.setCredit(testNum);
		assertEquals(testNum, testing.getCredit());
	}
}

