
package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.SalesOrder;

/**
 * Interface for pulling Order objects from the repository
 * @author Angus
 *
 */
public interface CustomerOrderRepository {
	
	public SalesOrder findByOrderID(int id);
	
	public SalesOrder findByCustID(String username);
	
	
}
