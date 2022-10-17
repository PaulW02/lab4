package com.kth.lab4.model.exceptions;

public class IllegalImageFormatException extends RuntimeException{

    public IllegalImageFormatException() {
        super();
    }

    public IllegalImageFormatException(String message) {
        super(message);
    }
}
