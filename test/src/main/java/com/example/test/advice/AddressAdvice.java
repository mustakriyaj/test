package com.example.test.advice;

import com.example.test.exception.AddressNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressAdvice {

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<String> handleAddressException(AddressNotFoundException exception){
        return new ResponseEntity("Address ID not found in the database", HttpStatus.NOT_FOUND);
    }
}
