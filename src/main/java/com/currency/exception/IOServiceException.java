package com.currency.exception;

public class IOServiceException extends RuntimeException {
    public IOServiceException() {
        super("IO Exception 발생");
    }
}

