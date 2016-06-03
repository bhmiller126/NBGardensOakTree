package com.qa.oaktree.repositories.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.oaktree.entities.Product;
import com.qa.oaktree.repositories.ProductRepository;
import com.qa.oaktree.util.PersistanceManager;

/**
 * This will become the SQL implementation of the repository.
 * There isn't much here right now, but in the future it will be.
 * I think this may be where we add sql queries
 * @author OakTree BM
 */
@Alternative
@Stateless
public class ProductRepositorySQL implements ProductRepository {
	@Inject private PersistanceManager persistanceManager;
	
	public Product findByIdAndDescriptionAndNameAndCategory(int catalogueId, String productDescription, String productName, String productCategory) {
		
		return null;
	}

	public Product findByCatalogueId(int catalogueId) {
		
		return null;	
	}
	public Product findByDescription(String productDescription) {
		
		return null;
	}
	
	public Product findByName(String productName) {
		
		return null;
	}
	public Product findByCategory(String productCategory) {
		
		return null;
	}

	
}