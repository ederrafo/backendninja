package com.ederrafo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Request mapping a nivel de clase
@RequestMapping("/say")
public class HelloWorldController {
    //Reques a nivel de metodo
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "helloWorld";
    }

}

// Con esta anotacion la haceos un bean de spring boot, es decir deja de ser una clase comun de java
