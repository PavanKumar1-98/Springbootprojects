package com.TestProject.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class restTemplate {


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
