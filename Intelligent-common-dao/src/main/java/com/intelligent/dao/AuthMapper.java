package com.intelligent.dao;


import com.intelligent.entity.Auth;
import com.intelligent.request.AuthRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {

    Auth selectInfo(@Param("param") AuthRequest request);
    
    int deleteByPrimaryKey(String id);

    int insert(Auth record);

    int insertSelective(Auth record);
    
    Auth selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);
}