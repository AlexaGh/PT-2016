package pt2016.project2.entity;

public class Customer {
	
	private int iCustomerId;
	private String sCustomerName;

	public Customer(){
//		this.customerId = 0;
//		this.customerName = "";
	}
	public Customer(int customerId, String customerName) {
		this.iCustomerId = customerId;
		this.sCustomerName = customerName;
	}

	public int getCustomerId() {
		return iCustomerId;
	}

	public void setCustomerId(int customerId) {
		this.iCustomerId = customerId;
	}

	public String getCustomerName() {
		return sCustomerName;
	}

	public void setCustomerName(String customerName) {
		this.sCustomerName = customerName;
	}

	@Override
	public String toString() {
		return String.format("\nCustomer: %d; %s>\n", iCustomerId, sCustomerName);
	}
}
