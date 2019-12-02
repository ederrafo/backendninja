package com.ederrafo.controller;


import com.ederrafo.entity.Course;
import com.ederrafo.service.CourseService;
import com.ederrafo.service.CourseServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {

    //Logging
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    private CourseService courseService;


    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView("courses/all");
        modelAndView.addObject("courses", courseService.all());
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
        return modelAndView;
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
        model.addAttribute("person", new Course());

        return "courses/add";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("course") Course course) {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod + " Params :" + course.toString());
        courseService.store(course);
        return  "redirect:/courses/all";
    }
}
