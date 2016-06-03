package com.qa.oaktree.repositories.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.oaktree.entities.SalesOrder;
import com.qa.oaktree.repositories.CustomerOrderRepository;
import com.qa.oaktree.util.PersistanceManager;

/**
 * SQL implementation of the repository
 * @author Angus
 *
 */
@Alternative
@Stateless
public class CustomerOrderRepositorySQL implements CustomerOrderRepository {
	@Inject private PersistanceManager pm;

	@Override
	public SalesOrder findByOrderID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrder findByCustID(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
