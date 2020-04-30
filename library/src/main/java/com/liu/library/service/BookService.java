package com.liu.library.service;

import com.liu.library.pojo.books;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {

    public List<books> getAll();
}
