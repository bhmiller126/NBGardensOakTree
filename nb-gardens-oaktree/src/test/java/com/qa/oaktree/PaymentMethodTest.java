package com.qa.oaktree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.oaktree.entities.PaymentMethod;

public class PaymentMethodTest {
	
	@Test public void testPaymentMethod(){
		PaymentMethod testing = new PaymentMethod();
		assertNull(testing.getUserName());
		}
	@Test public void testGetCardNumber(){
		PaymentMethod testing = new PaymentMethod();
		assertEquals("", testing.getCardNumber());
		}
	@Test public void testSetCardType(){
		PaymentMethod testing = new PaymentMethod();
		testing.setCardType(null);
		assertNotNull(testing.getCardType());
		}
	@Test public void testToString(){
		PaymentMethod testing = new PaymentMethod();
		testing.toString(); 
		}
	@Test public void testSetExpiryDate(){
		PaymentMethod testing = new PaymentMethod();
		testing.setExpiryDate(null);
		assertNull(testing.getExpiryDate());
		}
	@Test public void testSetBillingAddresss(){
		PaymentMethod testing = new PaymentMethod();
		testing.setBillingAddressLine1(null);
		testing.setBillingAddressPostcode(null);
		assertNull(testing.getBillingAddressLine1(), testing.getBillingAddressPostcode());
		}
	}

