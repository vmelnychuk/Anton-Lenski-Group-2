package org.training.vmelnychuk;

/**
 * Created by Vasyl_Melnychuk on 10/22/2014.
 */
public class TryThread extends Thread {
    private static int count = 0;
    @Override
    public void run() {
        Thread.currentThread().setName("Tread " + ++count);
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    }
}
