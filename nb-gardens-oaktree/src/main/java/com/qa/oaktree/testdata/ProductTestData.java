package com.qa.oaktree.testdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

import org.junit.Test;

import com.qa.oaktree.entities.Product;

/**
 * 
 * @author OakTree BM Product Test
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
		product.add(new Product(1, "gnome", "green gnome", "Gnomes", "in stock"));
	}
/**
 * this is an array list of products to test that the application runs correctly
 * @return
 */
	public List<Product> getProduct() {
		return product;
	}

/**
 * ths tests the getter for catalogue ID and should return null
 */
	@Test
	public void testGetCatalogueId() {
		Product testing = new Product();
		assertNull(testing.getCatalogueId());
	}
/**
 * tests the getter for product status and should return null
 */
	@Test
	public void testGetProductStatus() {
		Product testing = new Product();
		assertNull(testing.getProductStatus());
	}
	/**
	 * this method sets the product description then returns what we have set the description
	 * in this case it would be blank
	 */

	@Test
	public void testSetProductDescription() {
		Product testing = new Product();
		testing.setProductDescription(" ");
		assertEquals(" ", testing.getProductDescription());
	}
/**
 * this is testing the getter for product description and should return null 
 */
	@Test
	public void testGetProductDescription() {
		Product testing = new Product();
		assertNull(testing.getProductDescription());
	}
/**
 * this is testing the getter for product name, should return null
 */
	@Test
	public void testGetProductName() {
		Product testing = new Product();
		assertNull(testing.getProductName());
	}
	/**
	 * this is setting the product satatus to a space then getting the product status, should return nothing
	 */
	@Test public void setProductStatus(){
		Product testing = new Product();
		testing.setProductStatus(" ");
		assertNull(" ", testing.getProductStatus());
		}
}
