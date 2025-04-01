package com.TestProject.demo.Services;

import com.TestProject.demo.Dtos.ProductRequestDtos;
import com.TestProject.demo.models.Rating;
import com.TestProject.demo.Exception.ProductIncorrectException;
import com.TestProject.demo.Exception.ProductLimitReachedException;
import com.TestProject.demo.models.Product;
import com.TestProject.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class Productservice {
   // RestTemplate restTemplate= new RestTemplate();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllproducts(){
        ProductRequestDtos[] ProductRequestDtos1 = restTemplate.getForObject("https://fakestoreapi.com/products", ProductRequestDtos[].class);
        List<Product> productRequestDtoslist= new ArrayList<>();
        for(ProductRequestDtos ProductRequestDtos2:ProductRequestDtos1){
            productRequestDtoslist.add(getProduct(ProductRequestDtos2));
        }
    return productRequestDtoslist;

    }

    public  Product getSingleproduct(long id) throws Exception{
        if(id>20){
            throw new ProductLimitReachedException();
        }
        if(id>15 && id<19){
            throw new ProductIncorrectException();
        }
        ProductRequestDtos ProductRequestDtos2 = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductRequestDtos.class);
        return getProduct(ProductRequestDtos2);

    }
    public Product getProduct(ProductRequestDtos productRequestDtos){
        Product product= new Product();
        product.setId(product.getId());
        product.setTitle(productRequestDtos.getTitle());
        product.setImage(productRequestDtos.getImage());
        product.setPrice(productRequestDtos.getPrice());
        //product.setDescription(productRequestDtos.getDescription());
        product.setCategory(productRequestDtos.getCategory());
        Rating rating= new Rating();
        rating.setRate(productRequestDtos.getRating().getRate());
        rating.setCount(productRequestDtos.getRating().getCount());
        product.setRating(rating);
        productRepository.save(product);
        return product;
    }
}
