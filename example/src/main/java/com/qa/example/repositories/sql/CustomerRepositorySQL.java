package com.qa.example.repositories.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.example.entities.Customer;
import com.qa.example.repositories.CustomerRepository;
import com.qa.example.util.PersistanceManager;

/**
 * This will become the SQL implementation of the repository.
 * There isn't much here right now, but in the future it will be.
 * 
 * @author James Thompson
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