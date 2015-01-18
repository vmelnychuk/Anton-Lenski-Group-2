package org.training.reserveapp.service.exception;

public class EmailServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmailServiceException(String message) {
        super(message);
    }
}
