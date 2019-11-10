package com.ederrafo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Con esta anotacion la haceos un bean de spring boot, es decir deja de ser una clase comun de java
@Controller
@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "helloWorld";
    }

}
