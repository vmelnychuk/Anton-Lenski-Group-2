package org.training.patterns.lockfile.access.exception;

import org.apache.log4j.Logger;

public class FileSharingException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(FileSharingException.class);
    public FileSharingException(String message) {
        super(message);
        log.error(message);
    }
}
