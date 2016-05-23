package pt2016.project2.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
//	private int customerId;
	private Customer customer;
	private List<OrderDetails> orderDetails;// = new ArrayList<OrderDetails>();

	public Order() {
//		this.orderId = 0;
//		this.customer = new Customer();
	}

	public Order(int id) {
		this.orderId = 0;

		//this.setCustomerId(customerId);
	}

	public Order(int orderId, Customer customer, List<OrderDetails> orderdetails) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDetails = orderdetails;//.addAll(orderDetails);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\nOrder: %d; %s;\n", orderId, customer));
		sb.append("OrderDetails:");
		for (OrderDetails od : orderDetails) {
			sb.append(" " + od + ";");
		}
		sb.append(">");
		return sb.toString();
	}
}
