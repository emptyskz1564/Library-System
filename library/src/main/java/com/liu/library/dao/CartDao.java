package com.liu.library.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.library.pojo.cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartDao extends BaseMapper<cart> {
}
