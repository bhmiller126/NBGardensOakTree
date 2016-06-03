package com.qa.oaktree.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.entities.Product;
import com.qa.oaktree.repositories.ProductRepository;

/**
 * This stateless bean holds all the business logic associated with the customer entity.
 * 
 * @author OakTree BM
 */
@Stateless
public class ProductService {
	@Inject private ProductRepository productRepository;
	
	public boolean validateProduct (int catalogueId, String productCategory, String productDescription, String productName) {
		if (productRepository.findByIdAndDescriptionAndNameAndCategory(catalogueId, productDescription, productName, productCategory) != null)
			return false;
		return true;
	}

	public Product getCatalogueId(int catalogueId) {
		return productRepository.findByCatalogueId(catalogueId);
	}
	
	public  Product findByDescription(String productDescription) {
		return productRepository.findByDescription(productDescription);
	}
	public Product findByName(String productName) {
		return productRepository.findByName(productName);
	}
	
	public Product findByCategory(String productCategory) {
		return productRepository.findByCategory(productCategory);
	}
}