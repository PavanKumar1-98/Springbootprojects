package com.TestProject.demo.Dtos;

import com.TestProject.demo.models.Product;

public class ProductResponse {
    private Product product;
    private String erromessage;
    public ProductResponse(Product product,String errormessage){
        this.product=product;
        this.erromessage=errormessage;
    }
}
