package com.project.ataccama.exception;

public class ConnectionDetailsException extends RuntimeException {

    public ConnectionDetailsException(String message) {
        super(message);
    }

    public ConnectionDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
