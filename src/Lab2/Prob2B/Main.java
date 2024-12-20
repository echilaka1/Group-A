package Lab2.Prob2B;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order(LocalDate.of(2012, 2, 5), 1, 23.00, 4);
        order1.addOrderLine(2, 17.50, 1);
        Order order2 = new Order(LocalDate.of(2013, 4, 15), 1, 13.00, 2);
        order2.addOrderLine(2, 19.50, 1);
        order2.addOrderLine(3, 3.50, 2);
        Order order3 = new Order(LocalDate.of(2012, 2, 5), 1, 19.00, 1);
        order3.addOrderLine(2, 7.50, 1);
        order3.addOrderLine(3, 5.00, 1);
        order3.addOrderLine(4, 34.20, 1);
        Order order4 = new Order(LocalDate.of(2012, 2, 5), 1, 16.00, 4);
        order4.addOrderLine(2, 41.00, 3);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        System.out.println(orders);

    }

}