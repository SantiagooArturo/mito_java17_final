package com.mitocode.trabajofinaljava17.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalErrorHandler { //esta clase sirve para definir las excepciones que quiero interceptar
    @ExceptionHandler(ModelNotFoundException.class) //@ExceptionHandler -> capturador de excepciones
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoundException modelNotFoundException, WebRequest request){
        CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), modelNotFoundException.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
