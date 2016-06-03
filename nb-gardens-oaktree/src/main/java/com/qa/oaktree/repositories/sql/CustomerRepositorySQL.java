package com.qa.oaktree.repositories.SQL;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.oaktree.entities.Customer;
import com.qa.oaktree.repositories.CustomerRepository;
import com.qa.oaktree.util.PersistanceManager;

/**
 * SQL implementation of the repository
 * 
 * @author Barry
 */
@Alternative
@Stateless
public class CustomerRepositorySQL implements CustomerRepository {
	@Inject private PersistanceManager persistanceManager;
	
	public Customer findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}