package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.Product;

/**
 * This is the interface for pulling stock objects out of a repository.
 * when you want a check stock level THIS is what you inject.
 * 
 * @author OakTree BM
 */
public interface ProductRepository {
	public Product findByIdAndDescriptionAndNameAndCategory(int catalogueId, String productDescription, String productName, String productCategory);

	public Product findByCatalogueId(int catalogueId);
	
	public Product findByDescription(String productDescription);
	
	public Product findByName(String productName);
	
	public Product findByCategory(String productCategory); 
}