package com.liu.library.service;

import com.liu.library.pojo.books;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    //查看所有的图书列表
    public List<books> getAll();
    //购进一类图书
    public int add(books book);
    //卖出一本图书
    public int sold(Integer bookId);
    //模糊查询
    public List<books> search(String str);
}
