package org.training.vmelnychuk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasyl_Melnychuk on 10/22/2014.
 */
public class Order {
    private List<BigDecimal> orderList;

    public List<BigDecimal> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<BigDecimal> orderList) {
        this.orderList = orderList;
    }

    public Order() {
        this.orderList = new ArrayList<BigDecimal>();
    }

    public Order(List<BigDecimal> order) {
        this.orderList = order;
    }

    public Order addOrder(BigDecimal anOrder) {
        this.orderList.add(anOrder);
        return this;
    }

    public Order addOrder(String anOrderString) {
        BigDecimal order = new BigDecimal(anOrderString);
        this.orderList.add(order);
        return this;
    }
}
