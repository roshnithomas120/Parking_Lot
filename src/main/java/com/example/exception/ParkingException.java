package com.example.exception;

public class ParkingException extends RuntimeException{
    public ParkingException(String message) {
        super(message);
    }
}
