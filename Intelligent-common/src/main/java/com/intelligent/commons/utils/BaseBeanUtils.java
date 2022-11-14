package com.intelligent.commons.utils;

import com.dto.BaseForm;
import com.dto.ScoreForm;
import com.dto.UserForm;

public class BaseBeanUtils {
    public static <T extends BaseForm> T addForm(T form, T entity) {


        System.out.println(form.getOrgCode()+form.getOrgPath());
        entity.setOrgPath(form.getOrgPath());
        entity.setOrgCode(form.getOrgCode());
        System.out.println(entity.getOrgCode()+entity.getOrgPath());
        return entity;
    }

    public static void main(String[] args) {
        ScoreForm scoreForm = new ScoreForm();
        scoreForm.setScore("100");
        scoreForm.setCount("1");
        scoreForm.setOrgCode("00001");
        scoreForm.setOrgPath("00002");
        UserForm userForm = new UserForm();
        userForm.setUserName("user");
        userForm.setPassWord("1111");
        BaseBeanUtils.addForm(scoreForm,userForm);
    }
}
