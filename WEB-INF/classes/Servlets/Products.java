package Servlets;

public class Products {

	private String id;
	private String productName;
	private String productPrice;

	public Products(String id, String productName, String productPrice) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductPrice() {
		return productPrice;
	}
}
