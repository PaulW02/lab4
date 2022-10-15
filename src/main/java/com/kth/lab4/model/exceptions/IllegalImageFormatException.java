package com.kth.lab4.model.exceptions;

public class IllegalImageFormatException extends NullPointerException{

    public IllegalImageFormatException() {
    }

    public IllegalImageFormatException(String s) {
        super(s);
    }
}
