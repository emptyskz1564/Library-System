package com.liu.library.controller;

import com.liu.library.pojo.books;
import com.liu.library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cart")
@ResponseBody
public class cartController {

    @Autowired
    CartService cartServiceImpl;

    @RequestMapping("/getAll/{userId}")
    public List<books> getAll(@PathVariable("userId") Integer userId){
        return cartServiceImpl.userCart(userId);
    }

    @RequestMapping("/addToCart/{userId}/{bookId}")
    public int addToCart(@PathVariable("userId") Integer userId,@PathVariable("bookId") Integer bookId){
        return cartServiceImpl.addToCart(userId,bookId);
    }

}
