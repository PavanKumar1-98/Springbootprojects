package com.TestProject.demo.Exception;

import com.TestProject.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class exceptions {
    @ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<Product> ProductLimitReachedException(){
        return new ResponseEntity<>(null, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @ExceptionHandler(ProductIncorrectException.class)
    public ResponseEntity<Product> ProductIncorrectException(){
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
