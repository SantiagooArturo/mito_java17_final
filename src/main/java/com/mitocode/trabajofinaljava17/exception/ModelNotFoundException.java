package com.mitocode.trabajofinaljava17.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) //estoy haciendo que cuando suceda un error y acceda a esta clase se muestre como error 404
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }
}
