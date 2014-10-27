package org.training.vmelnychuk.order;

import org.apache.log4j.Logger;

import java.util.concurrent.Callable;

/**
 * Created by Vasyl_Melnychuk on 10/27/2014.
 */
public class CallableCalcOrder implements Callable<Long>{
    static final Logger log = Logger.getLogger(CalcOrder.class);
    private static long taskCount = 0;
    private final long id = taskCount++;
    private Order order = null;
    private long orderPrice;

    public CallableCalcOrder() {
        this.order = new Order();
    }
    public CallableCalcOrder(Order order) {
        this.order = order;
    }
    @Override
    public Long call() {
        orderPrice = order.calculatePrice();
        return orderPrice;
    }
    public Order getOrder() {
        return order;
    }
    public long getOrderPrice() {
        return orderPrice;
    }
    public long getId() {
        return id;
    }
}