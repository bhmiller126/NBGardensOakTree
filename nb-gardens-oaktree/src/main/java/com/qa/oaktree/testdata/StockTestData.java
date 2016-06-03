package com.qa.oaktree.testdata;

import static org.junit.Assert.*;
import org.junit.Test;
import com.qa.oaktree.entities.Stock;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 * 
 * @author OakTree BM
 *	Stock Test
 */
@Singleton	
public class StockTestData {
	
/**
	 * This hold our test data for testing that the application runs properly
	 * 
	 * 
	 */
	
	private List<Stock> stock;

		public void stockTestData() {
			stock = new ArrayList<Stock>();
			stock.add(new Stock (0, new BigDecimal(""), 1, 1, 1, "back order", "G4", 1));
		}
		
		public  List<Stock> getStock() {
			return stock;
		}
	
	
	
	@Test public void testGetCatalogueId() {
		Stock testing = new Stock(); 
		assertNull(testing.getCatalogueId());
	}
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


