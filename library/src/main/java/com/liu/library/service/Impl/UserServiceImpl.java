package com.liu.library.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.library.dao.UserDao;
import com.liu.library.pojo.user;
import com.liu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<user> getAll() {
        List<user> users = new ArrayList<>();
        users = userDao.selectList(null);
        return users;
    }

    @Override
    public List<user> getUserById(Integer userId) {
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return userDao.selectList(queryWrapper);
    }

    @Override
    public int regist(user user) {
        //这里的registUser为测试数据,后期还需改为传来的user
        user registUser = new user();
        registUser.setUserName("琦玉");
        registUser.setPassWord("156486");
        registUser.setUserPic("https:////");
        int insert = userDao.insert(registUser);
        return insert;
    }

    @Override
    public int update(user user) {
        //通过条件自动拼接动态sql
        user updateUser = new user();
        updateUser.setUserId(6);
        updateUser.setUserName("emptyskz");
        //这里会根据传递的updateUser的Id属性去修改其userName字段的内容
        int i = userDao.updateById(updateUser);
        return i;
    }

    @Override
    public int deleteUserById(Integer userId) {
        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        int i = userDao.delete(queryWrapper);
        return i;
    }


}
