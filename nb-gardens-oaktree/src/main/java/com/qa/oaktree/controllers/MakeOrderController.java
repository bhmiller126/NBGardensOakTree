package com.qa.oaktree.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.oaktree.service.UserService;

/**
 *This is the controller that handles all make order requests
 *
 * @author Stephen
 *
 */
@RequestScoped
public class MakeOrderController
{
	@Inject
	private UserService userService;
	@Inject
	private CurrentUser currentUser;
	//private PaymentMethod paymentMethod;
	
	/*setPaymentMethod(PaymentMethod paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}*/
	
	/*PaymentMethod getPaymentMethod()
	{
		return paymentMethod;
	}*/
	
	
}