package com.qa.oaktree.repositories.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.oaktree.entities.Product;
import com.qa.oaktree.repositories.ProductRepository;
import com.qa.oaktree.testdata.ProductTestData;

/**
 * This is the default implementation of the customer repository interface.
 * you DO NOT directly inject this, you ONLY INJECT the INTERFACE.
 * 
 * @author Oaktree BM
 */
@Default
@Stateless
public class ProductRepositoryOffline implements ProductRepository {
	@Inject private ProductTestData productTestData;
	
	public Product findByIdAndDescriptionAndNameAndCategory(int catalogueId, String productDescription, String productName, String productCategory) {
		for(Product product : productTestData.getProduct())
			if(product.getCatalogueId() == catalogueId && product.getProductDescription().equalsIgnoreCase(productDescription) && product.getProductName().equalsIgnoreCase(productName) && product.getProductCategory().equalsIgnoreCase(productCategory)) 
					
				return product;
		return null;
	}

	public Product findByCatalogueId(int catalogueId) {
		for(Product product : productTestData.getProduct())
			if((product.getCatalogueId() == catalogueId))
				return product;
		return null;
	}
	public Product findByDescription(String productDescription) {
		for(Product product : productTestData.getProduct())
			if((product.getProductDescription().equalsIgnoreCase(productDescription)))
				return product;
		return null;
	}
	
	public Product findByName(String productName) {
		for(Product product : productTestData.getProduct())
			if((product.getProductName().equalsIgnoreCase(productName)))
				return product;
		return null;
	}
	public Product findByCategory(String productCategory) {
		for(Product product : productTestData.getProduct())
			if((product.getProductCategory().equalsIgnoreCase(productCategory)))
				return product;
		return null;
	}
}