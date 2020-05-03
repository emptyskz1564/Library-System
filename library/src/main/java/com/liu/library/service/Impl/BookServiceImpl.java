package com.liu.library.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liu.library.dao.BooksDao;
import com.liu.library.pojo.books;
import com.liu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

    @Autowired
    BooksDao booksDao;

    @Override
    public List<books> getAll() {
        List<books> List = new ArrayList<>();
        List = booksDao.selectList(null);
        return List;
    }

    @Override
    public int add(books book) {
        int insert = booksDao.insert(book);
        return insert;
    }

    @Override
    public int sold(Integer bookId) {
        QueryWrapper<books> wrapper = new QueryWrapper<>();
        wrapper.eq("bookId",bookId);
        books book = booksDao.selectOne(wrapper);
        Integer bookCount = book.getBookCount();
        book.setBookCount(bookCount--);
        int update = booksDao.update(book, wrapper);
        return update;
    }

    @Override
    public List<books> search(String str) {
        QueryWrapper<books> wrapper = new QueryWrapper<>();

        wrapper
                .like("bookName",str)
                .like("bookType",str);

        return booksDao.selectList(wrapper);
    }
}
