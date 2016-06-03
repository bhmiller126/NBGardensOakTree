package com.qa.oaktree.repositories.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.oaktree.entities.SalesOrderLine;
import com.qa.oaktree.repositories.CustomerOrderLineRepository;
import com.qa.oaktree.util.PersistanceManager;

/**
 * SQL implementation of the repository
 * @author Angus
 *
 */
@Alternative
@Stateless
public class CustomerOrderLineRepositorySQL implements CustomerOrderLineRepository {
	@Inject private PersistanceManager pm;
	
	@Override
	public SalesOrderLine findByOrderAndProduct(int orderID, int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrderLine findByOrderID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
