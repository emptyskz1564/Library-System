package com.liu.library.controller;

import com.liu.library.pojo.user;
import com.liu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/v2")
@Controller
@ResponseBody
public class userController {

    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value = "/users" , method = RequestMethod.POST)
    public List<user> getAll(){
        return userServiceImpl.getAll();
    }

    @RequestMapping(value = "/user/{userId}" ,method = RequestMethod.POST)
    public List<user> getUserById(@PathVariable Integer userId){
        return userServiceImpl.getUserById(userId);
    }

    @RequestMapping(value = "/regist/{user}" ,method = RequestMethod.POST)
    public void regist(@PathVariable user user){
        userServiceImpl.regist(user);
    }

    @RequestMapping(value = "/update/{user}",method = RequestMethod.POST)
    public void updateUser(@PathVariable user user){
        userServiceImpl.update(user);
    }
}
