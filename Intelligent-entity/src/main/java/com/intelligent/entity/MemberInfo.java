package com.intelligent.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MemberInfo {

    /**
    * 分司编码
    */
    private String CompanyCode;

    /**
     * 性别男
     */
    private String sexMan;

    /**
     * 性别女
     */
    private String sexWomen;

    /**
     * 无性别
     */
    private String sexNo;

    /**
     * 小于25岁
     */
    private String ageOne;

    /**
     * 25-35岁
     */
    private String ageTwo;

    /**
     * 35-45岁
     */
    private String ageThree;

    /**
     * 45岁以上
     */
    private String ageFour;

    /**
     * 未知
     */
    private String ageFive;

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("8080_35-45岁","1");
        System.out.println(map.get("8080_35-45"));
    }
}
