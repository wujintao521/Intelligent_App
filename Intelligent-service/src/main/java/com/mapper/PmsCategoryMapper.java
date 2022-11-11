package com.mapper;

import com.model.dto.PmsCategory;

import java.util.List;

public interface PmsCategoryMapper {
    int deleteByPrimaryKey(Long catId);

    int insert(PmsCategory record);

    int insertSelective(PmsCategory record);

    PmsCategory selectByPrimaryKey(Long catId);

    int updateByPrimaryKeySelective(PmsCategory record);

    int updateByPrimaryKey(PmsCategory record);

    List<PmsCategory> getPmsCategoryInfo(PmsCategory pmsCategory);
}