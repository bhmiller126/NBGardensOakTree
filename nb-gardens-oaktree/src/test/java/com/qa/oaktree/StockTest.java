package com.qa.oaktree;

import static org.junit.Assert.*;
import org.junit.Test;
import com.qa.oaktree.entities.Stock;

/**
 * 
 * @author OakTree BM
 *	Stock Test
 */
public class StockTest {
	
	/**
	 * This test checks that the object of stock is null  
	 * 
	 * 
	 * 
	 */
		@Test public void testGetStockStatus(){
		Stock testing = new Stock();
		assertNull(testing.getStockStatus());
		}
	
	@Test public void testSetReorderLevel(){
		Stock testing = new Stock();
		testing.setReorderLevel(0);
		assertEquals(0, testing.getReorderLevel());
		}
	
}
