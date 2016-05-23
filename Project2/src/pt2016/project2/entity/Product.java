package pt2016.project2.entity;

public class Product {

	private int iProductId;
	private String sProductName;
	private int iProductQuantity;
	private double dProductPrice;

	public Product(){
		super();
	}
	public Product(int productId, String productName, int productQuantity, double productPrice) {
		this.iProductId = productId;
		this.sProductName = productName;
		this.iProductQuantity = productQuantity;
		this.dProductPrice = productPrice;
	}

	public int getProductId() {
		return iProductId;
	}

	public void setProductId(int productId) {
		this.iProductId = productId;
	}

	public String getProductName() {
		return sProductName;
	}

	public void setProductName(String productName) {
		this.sProductName = productName;
	}

	public int getProductQuantity() {
		return iProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.iProductQuantity = productQuantity;
	}

	public double getProductPrice() {
		return dProductPrice;
	}

	public void setProductPrice(double productPrice) {
		this.dProductPrice = productPrice;
	}

	@Override
	public String toString() {
		return String.format("<Product: %d; %s; %d; %f>", iProductId, sProductName, iProductQuantity, dProductPrice);
	}
}
