package com.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContrroller {

    @GetMapping("/hello")
    public String hello(){
        return "Hola mundo";
    }

    @GetMapping("/hello-secured")
    public String helloSecured(){
        return "Hola mundo seguro";
    }
}
