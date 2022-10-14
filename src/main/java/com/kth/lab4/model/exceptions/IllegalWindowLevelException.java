package com.kth.lab4.model.exceptions;

public class IllegalWindowLevelException extends RuntimeException {

    public IllegalWindowLevelException() {
    }

    public IllegalWindowLevelException(String message) {
        super(message);
    }
}
