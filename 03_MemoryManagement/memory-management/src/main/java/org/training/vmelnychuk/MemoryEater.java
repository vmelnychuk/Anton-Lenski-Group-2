package org.training.vmelnychuk;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MemoryEater {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        List v = new ArrayList();
        while (true) {
            try {
                byte b[] = new byte[1048576];
                v.add(b);
                Runtime rt = Runtime.getRuntime();
                logger.info("free memory: " + rt.freeMemory());
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                logger.error("Memory problems: ", e);
                v = new ArrayList();
            }
            /*try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }*/
        }
    }
}
