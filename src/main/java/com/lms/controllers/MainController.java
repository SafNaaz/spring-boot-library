package com.lms.controllers;

import com.lms.models.Book;
import com.lms.services.LmsService;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    LmsService lmsService;

    @GetMapping("/")
    public ModelAndView init(){
        ModelAndView model = new ModelAndView();
        model.addObject("books" , lmsService.findAllBooks());
        model.addObject("mode" , "BOOK_VIEW");
        model.setViewName("index");
        return model;
    }
    
    @GetMapping("/updateBook")
    public ModelAndView init(@RequestParam long id){
        ModelAndView model = new ModelAndView();
        model.addObject("book" , lmsService.findOne(id).get());
        model.addObject("mode" , "BOOK_EDIT");
        model.setViewName("index");
        return model;
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Book book){
    	lmsService.save(book);
        return "redirect:/";
    }
    
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
}
