package com.qa.oaktree.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.oaktree.controllers.CurrentUser;

/**
 * Handles wishlist view requests. Gets current user from session scoped CurrentUser
 * 
 * @author Barry
 *
 */
@Named(value = "wishlist")
@RequestScoped
public class WishlistController
{
	@Inject
	private CurrentUser currentUser;
	private String username;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = currentUser.getCurrentUser();
	}	
}