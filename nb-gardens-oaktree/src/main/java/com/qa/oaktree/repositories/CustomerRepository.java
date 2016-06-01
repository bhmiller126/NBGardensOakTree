package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.Customer;

/**
 * This is the interface for pulling customer objects from a repository.
 * 
 * @author Barry
 *
 */
public interface CustomerRepository
{
	public Customer findByUsernameAndPassword(String username, String password);
	
	public Customer findByUsername(String username);
}
