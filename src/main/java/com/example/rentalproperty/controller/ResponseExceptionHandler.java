package com.example.rentalproperty.controller;

import com.example.rentalproperty.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ContractDoesntExistException.class, LandlordDoesntExistException.class,
            TenantDoesntExistException.class, UserDoesntExistException.class})
    public ResponseEntity<?> handleNotFoundException(Exception exp) {
        return ResponseEntity.status(HttpStatus.NOT_EXTENDED).body(exp.getMessage());
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> handleIdNotFoundException(Exception e){
        return new ResponseEntity<>(new ErrorExtension(e.getMessage(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }
}
