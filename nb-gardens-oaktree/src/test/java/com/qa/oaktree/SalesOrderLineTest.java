package com.qa.oaktree;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.qa.oaktree.entities.Customer;
import com.qa.oaktree.entities.SalesOrderLine;

/**
 * Test class for constructor, getters and setters for Sales Order Line entity
 * @author Angus
 *
 */
public class SalesOrderLineTest {
	
	/**
	 * Test default null constructor creates an empty order line with0 quantity
	 */
	@Test public void testOrderLine () {
		SalesOrderLine testing = new SalesOrderLine(1); 
		assertEquals(0, testing.getQuantity());
	}
	
	/**
	 * Test null constructor sets the default order id to -1
	 */
	@Test public void testOrderLineOrderID(){
		SalesOrderLine testing =  new SalesOrderLine(1);
		assertEquals(-1, testing.getSalesOrder());
	}
	
	/**
	 * test full constructor saves quantity correctly
	 * 
	 */
	@Test public void testOrderLineCon(){
		SalesOrderLine testing = new SalesOrderLine(1, 5, 3, BigDecimal.valueOf(10));
		assertEquals(3, testing.getQuantity());
	}
	
	/**
	 * tests full constructor to make sure order line total correctly calculates the value of the order line
	 */
	@Test public void testOrderLineTotal(){
		SalesOrderLine testing = new SalesOrderLine(1, 5, 3, BigDecimal.valueOf(10));
		assertEquals(30,testing.getLineTotal());
	}
	
}
