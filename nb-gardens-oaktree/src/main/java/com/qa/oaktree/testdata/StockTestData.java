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

	/**
	 * this tests the getter for catalogue id and should return null 
	 */
	@Test
	public void testGetCatalogueId() {
		Stock testing = new Stock();
		assertNull(testing.getCatalogueId());
	}

	/**
	 *  tetsting the getter for stock status and should return null due to assert null 
	 */
	@Test
	public void testGetStockStatus() {
		Stock testing = new Stock();
		assertNull(testing.getStockStatus());
	}

	/**
	 * setting the stock status to a space then returning nothing by using getter for staock status
	 * 
	 */
	@Test
	public void testSetStockStatus() {
		Stock testing = new Stock();
		testing.setStockStatus(" ");
		assertEquals(" ", testing.getStockStatus());
	}

	/**
	 * 	setting the warehouse location to n and the getter should return n 
	 */
	@Test
	public void testSetWarehouseLocation() {
		Stock testing = new Stock();
		testing.setWarehouseLocation("n");
		assertEquals("n", testing.getWarehouseLocation());
	}

	/**
	 * 	testing the get warehouse location by using assert null
	 */
	@Test
	public void testGetWarehouseLocation() {
		Stock testing = new Stock();
		assertNull(testing.getWarehouseLocation());
	}

	/**
	 * setting the sale price to null means that assert equals should return null 
	 */

	@Test
	public void testSetSalesPrice() {
		Stock testing = new Stock();
		testing.setSalePrice(null);
		assertEquals(null, testing.getSalePrice());
	}

	/**
	 * 	this is the getter for getting the current quantity of stock in the warehouse
	 */
	@Test
	public void testGetCurrentQuantity() {
		Stock testing = new Stock();
		assertNull(testing.getCurrentQuantity());
	}

	/**
	 * 	if a product becomes popular the reorder quanity needs adjusting, this tests setting the reorder quantity then returning 0 
	 */
	@Test
	public void testSetReorderQuantity() {
		Stock testing = new Stock();
		testing.setReorderQuantity(0);
		assertEquals(0, testing.getReorderQuantity());
	}

	/**
	 * 	this tests the reorder quantity and asserts to null
	 */
	@Test
	public void testGetReorderQuantity() {
		Stock testing = new Stock();
		assertNull(testing.getReorderQuantity());
	}

	/**
	 * 	this tests the getter for reorder level, should return null
	 */
	@Test
	public void testGetReOrderLevel() {
		Stock testing = new Stock();
		assertNull(testing.getReorderLevel());
	}

	/**
	 * 	this will set the reorder level at 0 and then should return that value
	 */
	@Test
	public void testSetReorderLevel() {
		Stock testing = new Stock();
		testing.setReorderLevel(0);
		assertEquals(0, testing.getReorderLevel());
	}
}
