package com.example.rentalproperty.exception;

public class LandlordDoesntExistException extends RuntimeException {
    public LandlordDoesntExistException(String message) {
        super(message);
    }
}
