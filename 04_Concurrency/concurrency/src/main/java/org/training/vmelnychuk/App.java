package org.training.vmelnychuk;

import org.apache.log4j.Logger;
import org.training.vmelnychuk.order.RunCalcOrder;

public class App {
    static final Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        RunCalcOrder.run();
    }
}
