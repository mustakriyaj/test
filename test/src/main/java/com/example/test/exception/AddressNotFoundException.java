package com.example.test.exception;

public class AddressNotFoundException extends Exception{
    public AddressNotFoundException() {
        super();
    }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
