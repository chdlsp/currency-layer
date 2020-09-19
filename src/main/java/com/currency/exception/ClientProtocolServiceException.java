package com.currency.exception;

public class ClientProtocolServiceException extends RuntimeException {
    public ClientProtocolServiceException() {
        super("ClientProtocolException 발생");
    }
}

