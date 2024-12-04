package Lab5.Prob2;

import java.time.LocalDate;

public class CustomerOrderFactory {
        public static Customer newCustomer(String name) {
            return new Customer(name);
        }
        public static Order newOrder(Customer customer, LocalDate orderDate) {
            Order order = new Order(orderDate);
            customer.addOrder(order);
            return order;

        }
        public static Item newItem(String name) {
            return new Item(name);
        }
}
