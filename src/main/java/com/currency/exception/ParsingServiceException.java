package com.currency.exception;

public class ParsingServiceException extends RuntimeException {
    public ParsingServiceException() {
        super("Parsing Error 발생");
    }
}

