package com.ederrafo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ilustration")
public class ilustrationController {

    private static final String TEMPLATE_VIEW = "ilustration";

    // localhost:8080/ilustration/request1?name=Eder
    @GetMapping("/request1")
    public ModelAndView request1(@RequestParam(name = "name", required = false, defaultValue = "Abu Muhammad") String name){
        ModelAndView modelAndView = new ModelAndView(TEMPLATE_VIEW);
        modelAndView.addObject("name", name);

        return modelAndView;
    }

    // localhost:8080/ilustration/request2/Rafo
    @GetMapping("/request2/{name}")
    public ModelAndView request2(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView(TEMPLATE_VIEW);
        modelAndView.addObject("name", name);

        return  modelAndView;
    }

}
