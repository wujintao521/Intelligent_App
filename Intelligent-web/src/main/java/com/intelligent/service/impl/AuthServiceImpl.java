package com.intelligent.service.impl;

import com.intelligent.basic.exception.ServiceException;
import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.dao.AuthMapper;
import com.intelligent.entity.Auth;
import com.intelligent.request.AuthRequest;
import com.intelligent.service.AuthService;
import com.intelligent.utils.ValidateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    final AuthMapper authMapper;

    @Override
    public ResponseMessage login(AuthRequest request) {
        loginCheck(request);
        Auth auth = authMapper.selectInfo(request);
        if(ObjectUtils.isEmpty(auth)){
            throw new ServiceException("用户名密码不存在");
        }
        Map<String,String> map = new HashMap<>();
        map.put("accessToken","123456");
        return Result.success("登录成功",map);
    }

    private void loginCheck(AuthRequest request) {
        ValidateUtil.checkField(request::getUserName,"用户名不能为空");
        ValidateUtil.checkField(request::getPassWord,"密码不能为空");
    }

}
