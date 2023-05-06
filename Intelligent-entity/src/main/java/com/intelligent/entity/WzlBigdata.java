package com.intelligent.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * wzl_bigdata
 * @author
 */
@Data
public class WzlBigdata implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 时间
     */
    private Date time;

    /**
     * 数量
     */
    private BigDecimal num;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 更新标志
     */
    private String updateFlag;

    /**
     * 字典
     */
    private String dict;

    private static final long serialVersionUID = 1L;
}