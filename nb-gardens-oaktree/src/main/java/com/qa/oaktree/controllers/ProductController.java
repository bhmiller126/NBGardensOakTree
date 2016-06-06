package com.qa.oaktree.controllers;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.oaktree.service.ProductService;

/**
 * This is the controller that handles accessing of products
 *
 * @author OakTree BM
 *
 */
@Named(value = "products")
@SessionScoped
public class ProductController {
	@Inject
	private ProductService productService;
	@Inject
	private CurrentUser currentUser;
	private String error = "";
	private int catalogueId = 0;
	private String productDescription = "";
	private String productName = "";
	private String productCategory = "";
	private String searchBar = "";

	public String SearchDoesNotMatch() {
		if (searchBar.isEmpty()) {
			error = "Please Enter a search term";

			return "home";
		}

		if (!searchBar.contains(productDescription)) {
			error = "That product has not been found, please try again";
			productDescription = "";
			return "home";
		}

		if (!searchBar.equals(catalogueId)) {
			error = "That product has not been found, please try again";
			catalogueId = 0;
			return "home";
		}

		if (!searchBar.contains(productName)) {
			error = "That product has not been found, please try again";
			productName = "";
			return "home";
		}
		if (!searchBar.contains(productCategory)) {
			error = "That product has not been found, please try again";
			productCategory = "";
			return "home";
		}
		
		if (!productService.validateProduct(catalogueId, productCategory, productDescription, productName)) {
			error = "";
			
			return "home";
		}
		
		return "home";
	}
	public String SearchDoesMatch()
	{
		if (searchBar.isEmpty()) {
			error = "Please Enter a search term";

			return "home";
		}

		if (searchBar.contains(productDescription)) {
			productDescription = "";
			return "search result";
		}

		if (searchBar.equals(catalogueId)) {
			catalogueId = 0;
			return "search result";
		}

		if (!searchBar.contains(productName)) {
			productName = "";
			return "search result";
		}
		if (!searchBar.contains(productCategory)) {
			productCategory = "";
			return "search result";
		}
		
		if (productService.validateProduct(catalogueId, productCategory, productDescription, productName)) {
			
			
			return "";
		}
		
		return "home";
	}
	

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the searchBar
	 */
	public String getSearchBar() {
		return searchBar;
	}

	/**
	 * @param searchBar the searchBar to set
	 */
	public void setSearchBar(String searchBar) {
		this.searchBar = searchBar;
	}
}

	
