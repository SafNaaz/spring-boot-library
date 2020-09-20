package com.lms.controllers;

import com.lms.services.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LmsService lmsService;

    @GetMapping("/")
    public ModelAndView init(){
        ModelAndView model = new ModelAndView();
        model.addObject("books" , lmsService.findAllBooks());
        model.setViewName("index");
        return model;
    }
}
