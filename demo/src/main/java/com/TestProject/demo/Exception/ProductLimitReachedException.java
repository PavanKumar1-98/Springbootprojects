package com.TestProject.demo.Exception;

public class ProductLimitReachedException extends Exception {
    public ProductLimitReachedException(){
        super("product limit reached hence throwing exception");
    }
}
