package org.training.vmelnychuk.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasyl_Melnychuk on 10/24/2014.
 */
public class OrderGenerator {
    public static List<Order> getOrderListWithLength(int length) {
        List<Order> orders = new ArrayList<Order>();
        for(int i = 0; i < length;i++) {
            orders.add(new Order());
        }
        return orders;
    }
}
