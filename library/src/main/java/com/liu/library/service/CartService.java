package com.liu.library.service;

import com.liu.library.pojo.books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    //查看某用户的购物车信息
    public List<books> userCart(Integer userId);
    //加入购物车
    public int addToCart(Integer userId,Integer bookId);
    //生成订单
    public List<books> Order(Integer[] bookIds);
}
