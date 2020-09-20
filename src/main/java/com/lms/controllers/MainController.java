package com.lms.controllers;

import com.lms.services.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    LmsService lmsService;

    @GetMapping("/")
    public String init(HttpServletRequest request){
        request.setAttribute("books" , lmsService.findAllBooks());
        return "index";
    }
}
