package com.qa.example.repositories;

import com.qa.example.entities.Customer;

/**
 * This is the interface for pulling customer objects out of a repository.
 * when you want a Customer THIS is what you inject.
 * 
 * @author James Thompson
 */
public interface CustomerRepository {
	public Customer findByUsernameAndPassword(String username, String password);

	public Customer findByUsername(String username);
}