package org.training.vmelnychuk.order;

import java.util.Random;

/**
 * Created by Vasyl_Melnychuk on 10/24/2014.
 */
public class Order {
    private long price;
    public Order() {
        this.price = 0;
    }
    public long calculatePrice() {
        Random random = new Random();
        price = random.nextInt(200) + 1;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return price;
    }
    public long getPrice() {
        return price;
    }
}
