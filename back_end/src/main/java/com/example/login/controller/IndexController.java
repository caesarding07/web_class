package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
