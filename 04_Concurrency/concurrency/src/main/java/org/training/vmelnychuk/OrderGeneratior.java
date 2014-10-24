package org.training.vmelnychuk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vasyl_Melnychuk on 10/22/2014.
 */
public class OrderGeneratior {
    private static final int HIGH_PRICE_BOUND = 1000;
    private static final int DEFAULT_ORDER_SIZE = 10;
    public static List<Order> getOrderListWithLength(int length) {
        return getOrderListWithLengthAndOrderSize(length, DEFAULT_ORDER_SIZE);
    }

    public static List<Order> getOrderListWithLengthAndOrderSize(int length, int size) {
        List<Order> orders = new ArrayList<Order>(length);

        for(int i = 0; i < length; i++) {
            List<BigDecimal> productPrices = new ArrayList<BigDecimal>(size);
            for(int j = 0; j < size; j++) {
                Random priceGenerator = new Random();
                priceGenerator.nextInt(HIGH_PRICE_BOUND);
                BigDecimal price = (new BigDecimal(priceGenerator.nextFloat() + priceGenerator.nextInt(HIGH_PRICE_BOUND))).setScale(2, BigDecimal.ROUND_CEILING);
                productPrices.add(price);
            }
            orders.add(new Order(productPrices));
        }
        return orders;
    }
}
