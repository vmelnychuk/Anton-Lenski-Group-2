package org.training.vmelnychuk;

/**
 * Created by Vasyl_Melnychuk on 10/23/2014.
 */
public class RaceCondition {
    private int sharedResource = 0;

    public void startTwoThreads() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource++;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sharedResource--;
            }
        });

        t1.start();
        t2.start();
    }

    public void checkValue() {
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(sharedResource);
                    Thread.sleep(2000);
                    System.out.println(sharedResource);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.start();
    }

    public static void main(String[] args) {
        RaceCondition r = new RaceCondition();
        r.startTwoThreads();
        r.checkValue();
    }
}
