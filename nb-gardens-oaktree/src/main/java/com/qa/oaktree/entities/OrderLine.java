package com.qa.oaktree.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Sales_Order_Line")
@SecondaryTables({ @SecondaryTable(name = "Sales_Order_Rerturn_Line"), 
	@SecondaryTable(name = "Purchase_Order_Line"),
	@SecondaryTable(name = "Purchase_Order_Return_Line") })
public class OrderLine {

	@ManyToOne
	@JoinColumn(name = "Stock_catalogue_id", nullable = false)
	@NotNull
	private Product product;

	@Column(name = "sales_quantity", table="Sales_Order_Line")
	private int quantity;
	private int returnToShelf;
	private double unitCost;
	private double lineTotal;

	public OrderLine(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public OrderLine(Product product, int quantity, double unitCost) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.unitCost = unitCost;
	}

	public OrderLine(Product product, int quantity, int returnToShelf) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.returnToShelf = returnToShelf;
	}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReturnToShelf() {
		return returnToShelf;
	}

	public void setReturnToShelf(int returnToShelf) {
		this.returnToShelf = returnToShelf;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

}
