import java.util.ArrayList;
import java.util.List;

public class Main {
	List<OrderItem> orderItems = new ArrayList<>();

	public static void main(String[] args) {
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " +
				m.findProduct("Flowers"));
	}

	private boolean findProduct(String prodName) {
		// using strams
		return orderItems.stream()
				.map(OrderItem::getProduct)
				.map(Product::getProductName)
				.filter(name -> name != null)
				.anyMatch(name -> name.equals(prodName));

		// for (OrderItem item : orderItems) {
		// if (item != null) {
		// Product p = item.getProduct();
		// if (p != null) {
		// String name = p.getProductName();
		// if (name != null) {
		// if (name.equals(prodName))
		// return true;
		// }
		// }
		// }
		// }
		// return false;
	}

	private void loadOrderItemData() {
		orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
		orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
		orderItems.add(new OrderItem(new Product("1018", "Game of Go", 66.00), 2));
		orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
	}
}
