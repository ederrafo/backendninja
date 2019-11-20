package com.ederrafo.controller;

import com.ederrafo.component.LogComponent;
import com.ederrafo.model.Person;
import com.ederrafo.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/persons")
public class PersonController {

    public static final String TEMPLATE_PEOPLES = "peoples";

    @Autowired
    @Qualifier("logComponent")
    private LogComponent logComponent;

    // Inyectamos el servicio
    @Autowired
    @Qualifier("personServiceImpl")
    private PersonService personService;

    @GetMapping("/")
    public ModelAndView peoples(){
        ModelAndView model = new ModelAndView(TEMPLATE_PEOPLES);
        model.addObject("peoples", personService.getAllPerson());
        //logComponent.info();
        /*
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        System.out.println("Name of current method: "
                + nameofCurrMethod);
        */

        return model;
    }



    @GetMapping("/add")
    public String add(Model model)
    {
        // le pasamos un objecto vacio
        model.addAttribute("person", new Person());

        // test log trace
//        LOGGER.info("Info trace");
//        LOGGER.warn("Warning trace");
//        LOGGER.error("Error trace");
//        LOGGER.debug("Debug trace");
        return "person-add";
    }

    @PostMapping("/save")
    //capturamos el objeto person
    public ModelAndView save(@ModelAttribute("person") Person person){
//        LOGGER.info("Method: 'Person save' --params: '" + person + "'");
        ModelAndView modelAndView = new ModelAndView("person-save");
        modelAndView.addObject("person", person);
//        LOGGER.info("Template: 'person-save' --data: '" + person + "'");

        return modelAndView;
    }

}
