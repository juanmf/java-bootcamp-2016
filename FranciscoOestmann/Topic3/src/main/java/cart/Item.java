package cart;

public class Item {

	private String productName;
	private double productPrice;
	private static  int productQuantity = 0;
	
	//Constructor
	public Item(String productName, double productPrice) {
	
		this.productName = productName;
		this.productPrice = productPrice;
		productQuantity++;

	}

	//Getters & Setters
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public static int getProductQuantity() {
		return productQuantity;
	}
	
	
	
	
}
