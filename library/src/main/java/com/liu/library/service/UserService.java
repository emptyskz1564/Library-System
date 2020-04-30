package com.liu.library.service;

import com.liu.library.pojo.user;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    //获取所有的用户信息
    public List<user> getAll();
    //获取单个用户的信息
    public List<user> getUserById(Integer userId);
    //注册用户信息
    public int regist(user user);
    //更新用户信息
    public int update(user user);
 }
