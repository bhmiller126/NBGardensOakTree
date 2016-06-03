package com.qa.oaktree.repositories.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.oaktree.StockTestData;
import com.qa.oaktree.entities.Stock;
import com.qa.oaktree.repositories.StockRepository;

/**
 * This is the default implementation of the customer repository interface.
 * you DO NOT directly inject this, you ONLY INJECT the INTERFACE.
 * 
 * @author Oaktree BM
 */
@Default
@Stateless
public class StockRepositoryOffline implements StockRepository {
	@Inject private StockTestData stockTestData;
	
	public Stock findByCatalogueIdAndStockStatus(int catalogueId, String stockStatus) {
		for(Stock stock : stockTestData.getStock())
			if(stock.getCatalogueId() == catalogueId && stock.getStockStatus().equalsIgnoreCase(stockStatus)) 
					
				return stock;
		return null;
	}

	public Stock findByCatalogueId(int catalogueId) {
		for(Stock stock : stockTestData.getStock())
			if((stock.getCatalogueId() == catalogueId))
				return stock;
		return null;
	}
}