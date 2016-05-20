package src.main.java.com.qa.oaktree.entities;

import java.util.Date; 

public class SalesOrderReturn {
	private int salesOrderId; 
	private Date date; 
	private String reason;
	
	public SalesOrderReturn (int salesOrderId, Date date, String reason) {
		this.salesOrderId = salesOrderId; 
		this.date = date; 
		this.reason = reason; 
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
