package com.intelligent.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * test
 * @author 
 */
@Data
public class Test implements Serializable {
    private String id;

    private String name;

    private Integer age;

    private static final long serialVersionUID = 1L;
}