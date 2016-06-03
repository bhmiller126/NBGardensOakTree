package com.qa.example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.example.repositories.CustomerRepository;

/**
 * This stateless bean holds all the business logic associated with the customer entity.
 * 
 * @author James Thompson
 */
@Stateless
public class UserService {
	@Inject private CustomerRepository customerRepository;
	
	public boolean validateCredentials(String username, String password) {
		if (customerRepository.findByUsernameAndPassword(username, password) == null)
			return false;
		return true;
	}

	public long getUserID(String username) {
		return customerRepository.findByUsername(username).getId();
	}
}