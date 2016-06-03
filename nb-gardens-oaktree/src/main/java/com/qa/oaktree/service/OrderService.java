package com.qa.oaktree.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.CustomerRepository;

/**
 * Stateless bean to hold business logic associated with the customer entity
 * @author Angus
 *
 */
@Stateless
public class OrderService {
	@Inject private CustomerRepository custRepo;
	
	
	//TO-DO Add Order Logic methods Here
	
}
