package com.example.rentalproperty.exception;

public class TenantDoesntExistException extends RuntimeException {

    public TenantDoesntExistException(String message) {
        super(message);
    }
}
