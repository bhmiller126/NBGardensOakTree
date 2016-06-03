package com.qa.oaktree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

import org.junit.Test;

import com.qa.oaktree.entities.Product;

/**
 * 
 * @author OakTree BM
 *Product Test
 */
@Singleton
public class ProductTestData {
	/**
	 * This hold our test data for testing that the application runs properly
	 * 
	 * 
	 */

	private List<Product> product;

	public void productTestData() {
		product = new ArrayList<Product>();
		product.add(new Product (1, "gnome", "green gnome", "Gnomes", "in stock"));
	}
	
	public  List<Product> getProduct() {
		return product;
	}
	@Test public void testGetCatalogueId() {
		Product testing = new Product(); 
		assertNull(testing.getCatalogueId());
	}
	@Test public void testGetStockStatus(){
		Product testing = new Product();
		assertNull(testing.getProductStatus());
		}
	
	@Test public void testSetProductDescription(){
		Product testing = new Product();
		testing.setProductDescription(" ");
		assertEquals(" ", testing.getProductDescription());
		}
}
