package com.qa.oaktree.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.CustomerRepository;

/**
 * This stateless bean hold business logic associated with the customer entity
 * 
 * @author Barry
 *
 */
@Stateless
public class UserService
{
	@Inject 
	private CustomerRepository customerRepository;
	
	public boolean validateCredentials(String username, String password)
	{
		if(customerRepository.findByUsernameAndPassword(username, password) == null)
			return false;
		return true;
	}
	
	public String getUserID(String username)
	{
		return customerRepository.findByUsername(username).getUserName();
	}
}
