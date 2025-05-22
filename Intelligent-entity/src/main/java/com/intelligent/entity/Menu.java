package com.intelligent.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * menu
 * @author 
 */
@Data
public class Menu implements Serializable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 导航编码
     */
    private String code;

    /**
     * 导航名称
     */
    private String name;

    /**
     * 图片类型
     */
    private String iconType;

    /**
     * 导航路径
     */
    private String url;

    /**
     * 子菜单
     */
    private List<Menu> children;

    private static final long serialVersionUID = 1L;
}