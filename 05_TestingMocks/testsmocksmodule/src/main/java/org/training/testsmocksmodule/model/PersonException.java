package org.training.testsmocksmodule.model;

public class PersonException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PersonException() {
		super();
	}
	public PersonException(String message) {
		super(message);
	}

}
