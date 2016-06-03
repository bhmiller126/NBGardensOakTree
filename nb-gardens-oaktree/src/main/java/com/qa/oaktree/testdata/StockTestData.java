package com.qa.oaktree.testdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

import org.junit.Test;

import com.qa.oaktree.entities.Stock;

/**
 * 
 * @author OakTree BM Product Test
 */
@Singleton
public class StockTestData {
	/**
	 * This hold our test data for testing that the application runs properly
	 * 
	 * 
	 */

	private List<Stock> stock;

	public void productTestData() {
		stock = new ArrayList<Stock>();
		stock.add(new Stock(1, new BigDecimal(" "), 1, 1, 1, " back order", "G3", 2));
	}

	public List<Stock> getStock() {
		return stock;
	}

	@Test
	public void testGetCatalogueId() {
		Stock testing = new Stock();
		assertNull(testing.getCatalogueId());
	}

	@Test
	public void testGetStockStatus() {
		Stock testing = new Stock();
		assertNull(testing.getStockStatus());
	}

	@Test
	public void testSetStockStatus() {
		Stock testing = new Stock();
		testing.setStockStatus(" ");
		assertEquals(" ", testing.getStockStatus());
	}
	
	@Test
	public void testSetWarehouseLocation(){
		Stock testing = new Stock(); 
		testing.setWarehouseLocation("n");
		assertEquals ("n", testing.getWarehouseLocation());
	}
	
	@Test
	public void testGetWarehouseLocation() {
		Stock testing = new Stock(); 
		assertNull(testing.getWarehouseLocation());
	}
	@Test 
	public void testSetSalesPrice() {
		Stock testing = new Stock ();
		testing.setSalePrice(null);
		assertEquals(null, testing.getSalePrice());
	}
	@Test
	public void testGetCurrentQuantity() {
		Stock testing = new Stock (); 
		assertNull(testing.getCurrentQuantity());
	}
	@Test
	public void testSetReorderQuantity() {
		Stock testing = new Stock ();
		testing.setReorderQuantity(0);
		assertEquals(0, testing.getReorderQuantity());
	}
	@Test
	public void testGetReorderQuantity() {
		Stock testing = new Stock (); 
		assertNull(testing.getReorderQuantity()); 
	}
	@Test
	public void testGetReOrderLevel() {
		Stock testing = new Stock (); 
		assertNull (testing.getReorderLevel()); 
	}
	@Test 
	public void testSetReorderLevel() {
		Stock testing = new Stock (); 
		testing.setReorderLevel(0);
		assertEquals(0, testing.getReorderLevel());
	}
}
	
	


