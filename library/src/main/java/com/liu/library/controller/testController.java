package com.liu.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","Hello Spring!");
        return "test";
    }
}
