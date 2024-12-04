package Lab5.Prob2.extpackage;

import java.time.LocalDate;

import Lab5.Prob2.Customer;
import Lab5.Prob2.CustomerOrderFactory;
import Lab5.Prob2.Order;

public class Main {
	public static void main(String[] args) {
//		Customer cust = new Customer("Bob");
//		Order order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Shirt");
//		order.addItem("Laptop");
//
//		order = Order.newOrder(cust, LocalDate.now());
//		order.addItem("Pants");
//		order.addItem("Knife set");
//
//		System.out.println(cust.getOrders());

		Customer cust = CustomerOrderFactory.newCustomer("Bob");
		Order order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem(CustomerOrderFactory.newItem("Shirt"));
		order.addItem(CustomerOrderFactory.newItem("Laptop"));

		order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem(CustomerOrderFactory.newItem("Pants"));
		order.addItem(CustomerOrderFactory.newItem("Knife set"));

		System.out.println(cust.getOrders());
	}
}

		
