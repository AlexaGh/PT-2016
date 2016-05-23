package pt2016.project2.entity;

public class OrderDetails {

	private int orderId;
	private Product product;
	private int quantity;

	public OrderDetails() {
//		this.orderId = 0;
//		this.product = new Product();
//		this.quantity = 0;
	}

	public OrderDetails(int orderId, Product product, int quantity) {
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return String.format("\nOrder Details: %d; %s; %d;\n", orderId, product, quantity);
	}
}
