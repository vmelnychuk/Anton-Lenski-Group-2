package org.training.vmelnychuk.forkjoin;

import org.apache.log4j.Logger;
import org.training.vmelnychuk.order.Order;
import org.training.vmelnychuk.order.OrderGenerator;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Vasyl_Melnychuk on 11/3/2014.
 */
public class ForkOrderCalc extends RecursiveAction {
    static final Logger log = Logger.getLogger(ForkOrderCalc.class);
    private Order[] orders;
    private long[] prices;
    private int startIndex;
    private int lengthOfTasks;
    protected final static int TASKS_AMOUNT = 5;
    public static final int TASKS = 1000;
    public static final int SUB_SUM_SIZE = 5;

    public ForkOrderCalc(Order[] orders, long[] prices, int startIndex, int length) {
        this.orders = orders;
        this.prices = prices;
        this.startIndex = startIndex;
        this.lengthOfTasks = length;
    }

    protected void computeDirectly() {
        for (int index = startIndex; index < startIndex + lengthOfTasks; index++) {
            prices[index] = orders[index].calculatePrice();
        }
    }
    @Override
    protected void compute() {
        if (lengthOfTasks <= TASKS_AMOUNT) {
            computeDirectly();
            return;
        } else {
            int split = lengthOfTasks / 2;
            invokeAll(new ForkOrderCalc(orders, prices, startIndex, split),
                    new ForkOrderCalc(orders, prices, startIndex + split, lengthOfTasks - split));
        }
    }

    public static void main(String[] args) {
        Order[] orders = OrderGenerator.getOrderArrayWithLength(TASKS);
        long[] prices = new long[TASKS];
        ForkOrderCalc orderCalc = new ForkOrderCalc(orders, prices, 0, orders.length);
        ForkJoinPool pool = new ForkJoinPool(TASKS/10);
        long startTime = System.currentTimeMillis();
        pool.invoke(orderCalc);
        long endTime = System.currentTimeMillis();
        log.info("Price calculation time " + (endTime - startTime) +
                " milliseconds.");
        for(int i = 0; i < prices.length; i +=SUB_SUM_SIZE ) {
            long subSum = 0;
            StringBuffer subSumString = new StringBuffer("Sub sum of ");
            for (int j = i; j < i + SUB_SUM_SIZE; j++) {
                subSum += prices[j];
                subSumString.append(j + " ");
            }
            log.info(subSumString + ": " + subSum);
        }
    }
}
