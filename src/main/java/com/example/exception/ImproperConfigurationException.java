package com.example.exception;

public class ImproperConfigurationException extends RuntimeException{

    public ImproperConfigurationException(String errorMessage) {
        super(errorMessage);
    }
}
