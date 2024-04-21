package com.example.rentalproperty.exception;


public class ContractDoesntExistException extends RuntimeException {
    public ContractDoesntExistException(String message) {
        super(message);
    }
}
