package com.intelligent.dao;

import com.intelligent.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    int insert(Test record);

    Test selectByPrimaryKey(String id);

    int updateByPrimaryKey(Test record);

    List<Test> selectList();

}