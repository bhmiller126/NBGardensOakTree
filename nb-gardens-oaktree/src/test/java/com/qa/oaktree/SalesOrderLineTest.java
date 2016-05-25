package com.qa.oaktree;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.qa.oaktree.entities.Customer;
import com.qa.oaktree.entities.SalesOrderLine;

public class SalesOrderLineTest {
	
	@Test public void testOrderLine () {
		SalesOrderLine testing = new SalesOrderLine(1); 
		assertEquals(0, testing.getQuantity());
	}
	
	@Test public void testOrderLineOrderID(){
		SalesOrderLine testing =  new SalesOrderLine(1);
		assertEquals(-1, testing.getSalesOrder());
	}
	
	@Test public void testOrderLineCon(){
		SalesOrderLine testing = new SalesOrderLine(1, 5, 3, BigDecimal.valueOf(10));
		assertEquals(3, testing.getQuantity());
	}
	
	@Test public void testOrderLineTotal(){
		SalesOrderLine testing = new SalesOrderLine(1, 5, 3, BigDecimal.valueOf(10));
		assertEquals(30,testing.getLineTotal());
	}
	
}
