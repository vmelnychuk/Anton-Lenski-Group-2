package org.training.testsmocksmodule;

import org.apache.log4j.Logger;


public class App {
	private final static Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ) {
    	logger.info("hello");
        System.out.println( "Hello World!" );
    }
}
