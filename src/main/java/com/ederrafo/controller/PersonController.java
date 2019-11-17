package com.ederrafo.controller;

import com.ederrafo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/add")
    public String add(Model model)
    {
        // le pasamos un objecto vacio
        model.addAttribute("person", new Person());
        return "person-add";
    }

    @PostMapping("/save")
    //capturamos el objeto person
    public ModelAndView save(@ModelAttribute("person") Person person){
        ModelAndView modelAndView = new ModelAndView("person-save");
        modelAndView.addObject("person", person);

        return modelAndView;
    }

}
