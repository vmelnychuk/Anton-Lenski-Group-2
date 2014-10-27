package org.training.vmelnychuk.order;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vasyl_Melnychuk on 10/24/2014.
 */
public class Order {
    private long price;
    private long calculatedPrice;
    public Order() {
        Random random = new Random();
        this.price = random.nextInt(200) + 1;
    }
    public long calculatePrice() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculatedPrice = price;
        return price;
    }
    public long getPrice() {
        return price;
    }
    public long getCalculatedPrice() {
        return calculatedPrice;
    }
}
