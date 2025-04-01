package com.TestProject.demo.controller;

import com.TestProject.demo.Dtos.ProductRequestDtos;
import com.TestProject.demo.Dtos.ProductResponse;
import com.TestProject.demo.Exception.ProductIncorrectException;
import com.TestProject.demo.Exception.ProductLimitReachedException;
import com.TestProject.demo.Services.Productservice;
import com.TestProject.demo.models.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    /*@Autowired
    Productservice productservice;*/

    private final Productservice productservice;

    public ProductController(Productservice productservice){
        this.productservice=productservice;
    }

    @GetMapping("/products")
    public List<Product> getAllproducts(){
       return productservice.getAllproducts();
    }

    /*@GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getsingleProduct(@PathVariable("id") long id) throws Exception {
        Product product1=null;
        try {
             product1 = productservice.getSingleproduct(id);

        }
        catch(Exception e) {
            ProductResponse valuenotfound = new ProductResponse(product1, "valuenotdound");
            return new ResponseEntity<>(valuenotfound, HttpStatusCode.valueOf(400));
        }
        ProductResponse valuefound = new ProductResponse(product1, "valuefounound");
        return new ResponseEntity<>(valuefound, HttpStatusCode.valueOf(200));
    }*/

    @GetMapping("/products1/{id}")
    public ResponseEntity<Product> getSingleProduct1(@PathVariable("id") long id) throws Exception {

            Product product = productservice.getSingleproduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);

    }





}
