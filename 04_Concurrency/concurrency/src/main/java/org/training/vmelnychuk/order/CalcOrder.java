package org.training.vmelnychuk.order;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Vasyl_Melnychuk on 10/24/2014.
 */
public class CalcOrder implements Runnable{
    static final Logger log = Logger.getLogger(CalcOrder.class);
    private static long taskCount = 0;
    private final long id = taskCount++;
    private Order order = null;
    private long orderPrice;

    public CalcOrder() {
        this.order = new Order();
    }
    @Override
    public void run() {
        orderPrice = order.calculatePrice();
        log.info("id: " + id + " " + "price: " + orderPrice);
    }
    public Order getOrder() {
        return order;
    }
    public long getOrderPrice() {
        return orderPrice;
    }
}
