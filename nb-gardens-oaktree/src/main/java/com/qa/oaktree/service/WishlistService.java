package com.qa.oaktree.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.oaktree.repositories.WishlistRepository;

/**
 * Stateless bean that holds wishlist request & business logic
 * 
 * @author Barry
 *
 */

@Stateless
public class WishlistService
{
	@Inject 
	private WishlistRepository wishlistRepository;
	
	public String getUserID(String username)
	{
		return wishlistRepository.displayWishlist(username).getCustomerUserName();
	}
}
