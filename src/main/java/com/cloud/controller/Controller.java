package com.cloud.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://34.127.76.90:3000",
        "http://localhost:3001", "http://34.127.76.90:3001",
        "http://localhost:3002", "http://34.127.76.90:3002"})
public class Controller {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Amlan Alok";
    }
}