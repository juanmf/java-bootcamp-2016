package shopping.cart.main;

public class Main {

	public static void main(String[] args) {

		ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("Ipod", 199.99);
		Item item2 = new Item("Ipad", 299.99);
		Item item3 = new Item("Ibook", 999.99);
		Item item4 = new Item("Iphone", 549.99);
		
		cart.AddItemToCart(item1);
		cart.AddItemToCart(item2);
		cart.AddItemToCart(item3);
		cart.AddItemToCart(item4);
		
		
		cart.displayCartContent();
		
		cart.removeItemFromCart(item1);
		cart.removeItemFromCart(item3);
		
		cart.displayCartContent();
		
		System.out.println(cart.calculateTotalPurchase());
	}

}
