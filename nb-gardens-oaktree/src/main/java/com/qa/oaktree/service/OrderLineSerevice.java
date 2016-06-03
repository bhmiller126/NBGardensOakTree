package com.qa.oaktree.service;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.CustomerOrderLineRepository;
import com.qa.oaktree.repositories.CustomerRepository;

/**
 * Stateless bean hold business logic associated with the customer order lines
 * @author Angus
 *
 */
@Stateless
public class OrderLineSerevice {

	@Inject private CustomerOrderLineRepository orderLineRepo;
	
	/**
	 * Calculates the order line total value
	 * @param price price of the product purchased
	 * @param quantity quantity of product bought
	 * @return Big Decimal containing price multiplied by quantity
	 */
	public BigDecimal calcTotal(BigDecimal price, int quantity){
		return price.multiply(BigDecimal.valueOf(quantity));
	}
}
