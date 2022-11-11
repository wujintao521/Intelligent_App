package com.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * pms_category
 * @author 
 */
@Data
public class PmsCategory implements Serializable {
    /**
     * 分类id
     */
    private Long catId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Long parentCid;

    /**
     * 层级
     */
    private Integer catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    private Byte showStatus;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 计量单位
     */
    private String productUnit;

    /**
     * 商品数量
     */
    private Integer productCount;

    private List<PmsCategory> pmsCategoryNodes;

    public Integer getSort() {
        return sort == null ? 0 : sort;
    }

    private static final long serialVersionUID = 1L;
}