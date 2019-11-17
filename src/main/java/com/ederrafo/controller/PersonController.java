package com.ederrafo.controller;

import com.ederrafo.model.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private static final Log LOGGER = LogFactory.getLog(PersonController.class);

    @GetMapping("/add")
    public String add(Model model)
    {
        // le pasamos un objecto vacio
        model.addAttribute("person", new Person());

        // test log trace
        LOGGER.info("Info trace");
        LOGGER.warn("Warning trace");
        LOGGER.error("Error trace");
        LOGGER.debug("Debug trace");
        return "person-add";
    }

    @PostMapping("/save")
    //capturamos el objeto person
    public ModelAndView save(@ModelAttribute("person") Person person){
        LOGGER.info("Method: 'Person save' --params: '" + person + "'");
        ModelAndView modelAndView = new ModelAndView("person-save");
        modelAndView.addObject("person", person);
        LOGGER.info("Template: 'person-save' --data: '" + person + "'");

        return modelAndView;
    }

}
