package com.liu.library.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.library.dao.BooksDao;
import com.liu.library.dao.CartDao;
import com.liu.library.pojo.books;
import com.liu.library.pojo.cart;
import com.liu.library.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cartServiceImpl")
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    BooksDao booksDao;

    @Override
    public List<books> userCart(Integer userId) {
        QueryWrapper<cart> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<cart> carts = cartDao.selectList(wrapper);
        ArrayList<books> books = new ArrayList<>();
        for (cart cart : carts) {
            QueryWrapper<books> bookWrapper = new QueryWrapper<>();
            bookWrapper.eq("book_id",cart.getBookId());
            books.add(booksDao.selectOne(bookWrapper));
        }
        return books;
    }

    @Override
    public int addToCart(Integer userId, Integer bookId) {
        int insert = cartDao.insert(new cart(userId, bookId));
        return insert;
    }

    @Override
    public List<books> Order(Integer[] bookIds) {
        QueryWrapper<books> booksQueryWrapper = new QueryWrapper<>();
        booksQueryWrapper.in("book_id",bookIds);
        List<books> books = booksDao.selectList(booksQueryWrapper);
        return books;
    }
}
