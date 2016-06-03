package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.SalesOrderLine;

/**
 * Interface for pulling order line objects from the repository
 * @author Angus
 *
 */
public interface CustomerOrderLineRepository {
	
	public SalesOrderLine findByOrderAndProduct(int orderID, int productID);
	
	public SalesOrderLine findByOrderID(int id);
	
}
