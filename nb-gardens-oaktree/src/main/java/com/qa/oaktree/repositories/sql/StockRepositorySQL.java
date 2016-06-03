package com.qa.oaktree.repositories.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.oaktree.entities.Stock;
import com.qa.oaktree.repositories.StockRepository;
import com.qa.oaktree.util.PersistanceManager;

/**
 * This will become the SQL implementation of the repository.
 * There isn't much here right now, but in the future it will be.
 * 
 * @author OakTree BM
 */
@Alternative
@Stateless
public class StockRepositorySQL implements StockRepository {
	@Inject private PersistanceManager persistanceManager;
	
	public Stock findByCatalogueIdAndStockStatus(int catalogueId, String stockStatus)  {
		// TODO Auto-generated method stub
		return null;
	}

	public Stock findByCatalogueId(int catalogueId) {
		// TODO Auto-generated method stub
		return null;
	}
}