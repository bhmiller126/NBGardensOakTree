package com.qa.example.repositories.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.example.entities.Customer;
import com.qa.example.repositories.CustomerRepository;
import com.qa.example.util.TestData;

/**
 * This is the default implementation of the customer repository interface.
 * you DO NOT directly inject this, you ONLY INJECT the INTERFACE.
 * 
 * @author James Thompson
 */
@Default
@Stateless
public class CustomerRepositoryOffline implements CustomerRepository {
	@Inject private TestData testData;
	
	public Customer findByUsernameAndPassword(String username, String password) {
		for(Customer customer : testData.getCustomers())
			if(customer.getUsername().equalsIgnoreCase(username) && customer.getPassword().equals(password))
				return customer;
		return null;
	}

	public Customer findByUsername(String username) {
		for(Customer customer : testData.getCustomers())
			if(customer.getUsername().equalsIgnoreCase(username))
				return customer;
		return null;
	}
}