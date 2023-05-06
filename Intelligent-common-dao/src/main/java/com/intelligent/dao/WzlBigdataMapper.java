package com.intelligent.dao;

import com.intelligent.entity.WzlBigdata;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WzlBigdataMapper {

    List<WzlBigdata> selectList();

    Integer selectCount();

}