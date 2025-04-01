package com.TestProject.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/bye")
    public String getBye(){

        return "we are getting the output";
    }

    @GetMapping("/bye1")
    public String getBu3(@RequestParam("id")String id){
        return "we are getting the output"+id;
    }

}
