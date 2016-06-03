package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.Stock;

/**
 * This is the interface for pulling stock objects out of a repository.
 * when you want a check stock level THIS is what you inject.
 * 
 * @author OakTree BM
 */
public interface StockRepository {
	public Stock findByCatalogueIdAndStockStatus(int catalogueId, String stockStatus);

	public Stock findByCatalogueId(int catalogueId);
}