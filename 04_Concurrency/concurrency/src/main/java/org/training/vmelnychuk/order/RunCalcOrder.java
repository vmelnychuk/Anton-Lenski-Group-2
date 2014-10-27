package org.training.vmelnychuk.order;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Vasyl_Melnychuk on 10/27/2014.
 */
public class RunCalcOrder {
    static final Logger log = Logger.getLogger(RunCalcOrder.class);
    public static final int ORDERS_SIZE = 1000;
    public static void run() {

        List<Order> orderList = OrderGenerator.getOrderListWithLength(ORDERS_SIZE);

        long startTime = System.currentTimeMillis();

        long totalPrice = 0;
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Long>> totalPriceListFuture =new ArrayList<Future<Long>>();
        for(int i = 0; i < ORDERS_SIZE; i++) {
            totalPriceListFuture.add(exec.submit(new CallableCalcOrder(orderList.get(i))));
        }

        int subPriceCounter = 0;
        long subPrice = 0;
        StringBuilder ids  = new StringBuilder();
        for(int i = 0; i < totalPriceListFuture.size(); i++) {
            try {
                subPriceCounter++;
                subPrice += totalPriceListFuture.get(i).get();
                ids.append(i + " ");
                totalPrice += totalPriceListFuture.get(i).get();
                if(subPriceCounter >= 5) {
                    log.info("subPrice of : " + ids + " " + subPrice);
                    subPriceCounter = 0;
                    subPrice = 0;
                    ids = new StringBuilder();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }

        System.out.println("Total price: " + totalPrice);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Time of running: " + elapsedTime);
    }
}
