package com.liu.library.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.library.pojo.books;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BooksDao extends BaseMapper<books> {
}
