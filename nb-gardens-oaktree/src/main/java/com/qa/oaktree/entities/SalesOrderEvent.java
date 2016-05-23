package com.qa.oaktree.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column; 
import javax.persistence.Id; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne; 
import javax.persistence.JoinColumn; 
import javax.print.attribute.DateTimeSyntax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Sales_Order_Event")
public class SalesOrderEvent {
	@Id
	@Column (name = "sales_event_id" )
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int salesEventId; 
	
	@ManyToOne
	@JoinColumn (name = "Sales_Order_sales_id", nullable = false)
	public int getSalesOrderId() {
		return salesOrderId;
	}
	@NotNull
	private int salesOrderId; 
	
	//TODO double check on date time stamp
	@Column (name = "time_stamp", nullable = false)
	@NotNull
	private DateTimeSyntax timeStamp;
	
	
	@Column (name = "description", nullable = true, length = 225)
	@Null
	@Size (min = 1, max =225)
	private String description; 
	
	@Column (name = "type", nullable = false, length = 20)
	@NotNull
	@Size (min = 1, max = 20)
	private String type; 
	
	public SalesOrderEvent (int salesEventId, int salesOrderId, DateTimeSyntax timeStamp, String description, String type) {
		this.salesEventId = salesEventId; 
		this.salesOrderId = salesOrderId; 
		this.timeStamp = timeStamp; 
		this.description = description; 
		this.type = type; 
		
	}

	public int getSalesEventId() {
		return salesEventId;
	}

	public void setSalesEventId(int salesEventId) {
		this.salesEventId = salesEventId;
	}

	

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public DateTimeSyntax getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTimeSyntax timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
