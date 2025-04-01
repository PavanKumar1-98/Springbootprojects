package com.TestProject.demo.Exception;

public class ProductIncorrectException extends Exception{

    public ProductIncorrectException(){
        super("product we should not query hence throwing exception");
    }
}
