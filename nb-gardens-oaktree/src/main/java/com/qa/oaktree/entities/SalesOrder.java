package src.main.java.com.qa.oaktree.entities;

public class SalesOrder {

	private int salesId; 
	private String customerUserName; 
	private String addressLine1; 
	private String addressPostcode; 
	
	public SalesOrder (int salesId, String customerUserName, String addressLine1, String addressPostcode) {
		this.salesId = salesId; 
		this.customerUserName = customerUserName; 
		this.addressLine1 = addressLine1; 
		this.addressPostcode = addressPostcode; 
		
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressPostcode() {
		return addressPostcode;
	}

	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}
}
