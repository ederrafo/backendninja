package com.ederrafo.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Le decimos a spring que esta clase se encarga de la captura de errores
@ControllerAdvice
public class ErrorsController {

    public static final String TEMPLATE = "error/500";

    // retornara la vista del error
    // get all tipo de excelciones
    @ExceptionHandler(Exception.class)
    public String error(){
        return TEMPLATE;
    }
}
