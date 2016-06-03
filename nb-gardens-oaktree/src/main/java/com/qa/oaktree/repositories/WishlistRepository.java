package com.qa.oaktree.repositories;

import com.qa.oaktree.entities.WishList;

/**
 * This is the interface for pulling stock objects out of a repository.
 * when you want a check stock level THIS is what you inject.
 * 
 * @author OakTree Barry
 */
public interface WishlistRepository
{
	public WishList displayWishlist(String username);
}
