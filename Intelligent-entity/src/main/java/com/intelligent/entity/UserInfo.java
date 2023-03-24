package com.intelligent.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_info
 * @author 
 */
@Data
public class UserInfo implements Serializable {
    private String uid;

    private String username;

    private String password;

    private Date createtime;

    private Date modifytime;

    private String deleted;

    private static final long serialVersionUID = 1L;
}