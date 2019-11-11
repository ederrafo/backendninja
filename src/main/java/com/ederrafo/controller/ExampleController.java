package com.ederrafo.controller;

import com.ederrafo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";
    // Primera forma
    // @RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    @GetMapping("/exampleString")
    // Necesitamos un model para pasarle parametros
    public String exampleString(Model model){
        // Si el model viene vacio entonces lo crea
        model.addAttribute("person", new Person("Eder", 34));

        return EXAMPLE_VIEW;
    }

    // Segunda forma
    // @RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView model = new ModelAndView(EXAMPLE_VIEW);
        model.addObject("person",  new Person("Rafo", 34));

        return model;
    }
}
