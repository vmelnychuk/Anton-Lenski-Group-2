package org.training.testsmocksmodule.model;

/**
 * Created by Vasyl_Melnychuk on 11/10/2014.
 */
public class PersonValidationException extends RuntimeException {
    public PersonValidationException() {
        super();
    }
    public PersonValidationException(String message) {
        super(message);
    }
}
