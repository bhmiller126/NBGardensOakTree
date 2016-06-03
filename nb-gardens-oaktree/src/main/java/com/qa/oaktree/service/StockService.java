package com.qa.oaktree.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.StockRepository;

/**
 * This stateless bean holds all the business logic associated with the customer entity.
 * 
 * @author OakTree BM
 */
@Stateless
public class StockService {
	@Inject private StockRepository stockRepository;
	
	public boolean validateStock (int catalogueId, String stockStatus) {
		if (stockRepository.findByCatalogueIdAndStockStatus(catalogueId, stockStatus) == null)
			return false;
		return true;
	}

	public int getCatalogueId(int catalogueId) {
		return stockRepository.findByCatalogueId(catalogueId).getCatalogueId();
	}
}