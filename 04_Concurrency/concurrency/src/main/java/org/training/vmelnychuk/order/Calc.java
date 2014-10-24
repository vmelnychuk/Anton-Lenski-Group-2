package org.training.vmelnychuk.order;

import java.util.List;

/**
 * Created by Vasyl_Melnychuk on 10/24/2014.
 */
public class Calc {
    public static void main(String[] args) {
        long totalSum = 0;
        List<Order> orders = OrderGenerator.getOrderListWithLength(1000);
        for(Order order : orders) {
            totalSum += order.calculatePrice();
        }
        System.out.println("Sum: " + totalSum);
    }
}
