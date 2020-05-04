package com.liu.library.controller;

import com.liu.library.pojo.books;
import com.liu.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v2")
@ResponseBody
public class booksController {

    @Autowired
    BookService bookServiceImpl;

    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public List<books> getAll(){
        return bookServiceImpl.getAll();
    }

    @RequestMapping(value = "/sold/{bookId}",method = RequestMethod.POST)
    public void sold(@PathVariable("bookId") int bookId){
        bookServiceImpl.sold(bookId);
    }

    @RequestMapping(value = "/search/{str}" , method = RequestMethod.POST)
    public List<books> search(@PathVariable("str") String str){
        List<books> search = bookServiceImpl.search(str);
        return search;
    }
}
