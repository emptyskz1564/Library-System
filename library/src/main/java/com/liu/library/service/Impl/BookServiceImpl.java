package com.liu.library.service.Impl;

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
}
