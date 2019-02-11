package com.example.testcustomwidgetslibrary.exception;

public class TagiException extends Exception {
    public TagiException() {
    }

    public TagiException(String message) {
        super(message);
    }

    public TagiException(String message, Throwable cause) {
        super(message, cause);
    }
}
