package com.liu.library.controller;

import com.liu.library.exceptions.MyExceptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/v1")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() throws MyExceptions {
        throw new MyExceptions(200,"hello");
    }
}
