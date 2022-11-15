package com.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserInfoVO {

    private static final long serialVersionUID = 1L;

    /**
     * user.id 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String uId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    /**
     * 删除标识 0正常,1删除
     */
    @ApiModelProperty(value = "删除标识 0正常,1删除")
    private String deleted;
}
